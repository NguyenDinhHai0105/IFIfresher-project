package com.example.fresherproject.security.jwt;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.fresherproject.security.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

//xác thực Mã thông báo bằng cách sử dụng JwtProvider
//class này có nhiệm vụ kiểm tra request của người dùng trước khi nó tới đích.
// Nó sẽ lấy Header Authorization ra và kiểm tra xem chuỗi JWT người dùng gửi lên có hợp lệ không.
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider tokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    //JwtAuthTokenFilter trích xuất tên người dùng / mật khẩu từ mã thông báo đã nhận bằng JwtProvider, sau đó dựa trên dữ liệu được trích xuất, JwtAuthTokenFilter:
    //- tạo một AuthenticationToken (triển khai xác thực)
    //- sử dụng AuthenticationToken làm đối tượng Xác thực và lưu trữ nó trong SecurityContext để sử dụng bộ lọc trong tương lai (ví dụ: bộ lọc Ủy quyền).
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // lấy jwt từ request
            String jwt = getJwt(request);
            if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
                //lấy user name từ chuỗi jwt
                String username = tokenProvider.getUserNameFromJwtToken(jwt);
                // lấy thông tin người dùng từ username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // nếu người dùng hợp lệ, set thông tin cho Security context
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        // kiểm tra xem header Authorization có chứa thông tin jwt không
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}
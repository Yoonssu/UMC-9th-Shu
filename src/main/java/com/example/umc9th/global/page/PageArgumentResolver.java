package com.example.umc9th.global.page;

import com.example.umc9th.global.apiPayload.exception.PageException;
import com.example.umc9th.global.apiPayload.exception.code.PageErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class)
                && (parameter.getParameterType().equals(Integer.class)
                || parameter.getParameterType().equals(int.class));
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String pageStr = request.getParameter("page");

        int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);

        if (page <= 0) {
            throw new PageException(PageErrorCode.INVALID_PAGE);
        }

        // 내부에서는 0-based 사용
        return page - 1;
    }
}

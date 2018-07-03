package com.hq.biz.handle;

import com.hq.biz.entity.Result;
import com.hq.biz.enums.ResultEnum;
import com.hq.biz.excepiton.BusinessExcpetion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

/**
 * @author huangqi
 * @Package com.hq.handle
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/27 18:51
 */
@RestControllerAdvice
public class ExceptionHandle {
    private static final Logger LOGGER = LoggerFactory.getLogger("Exception");


    @ExceptionHandler(value = BusinessExcpetion.class)
    public Result<BusinessExcpetion> handle(BusinessExcpetion e) {
        LOGGER.error(e.getMessage(), e);
        return new Result<>(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public Result handle(HttpClientErrorException e) {
        LOGGER.error(e.getMessage(), e);
        return new Result(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpServerErrorException.class)
    public Result handle(HttpServerErrorException e) {
        LOGGER.error(e.getMessage(), e);
        return new Result(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = UnknownHttpStatusCodeException.class)
    public Result handle(UnknownHttpStatusCodeException e) {
        LOGGER.error(e.getMessage(), e);
        return new Result(ResultEnum.SERVER_ERROR);
    }
}

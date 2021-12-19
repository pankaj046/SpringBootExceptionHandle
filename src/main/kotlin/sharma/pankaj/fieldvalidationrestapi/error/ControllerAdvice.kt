package sharma.pankaj.fieldvalidationrestapi.error

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import sharma.pankaj.fieldvalidationrestapi.model.ResponseModel
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestControllerAdvice
class ControllerAdvice : ResponseEntityExceptionHandler() {

    //tested
    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(ResponseModel(true, "bad request"))
    }

    //tested
    override fun handleHttpMediaTypeNotSupported(
        ex: HttpMediaTypeNotSupportedException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(ResponseModel(true, "Not supported media type"))
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(ResponseModel(true, "Internal server error"))
    }

    override fun handleHttpRequestMethodNotSupported(
        ex: HttpRequestMethodNotSupportedException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(ResponseModel(true, "Request method not supported"))
    }

    override fun handleHttpMediaTypeNotAcceptable(
        ex: HttpMediaTypeNotAcceptableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(ResponseModel(true, "Media type not acceptable"))
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = ex.bindingResult.allErrors[0].defaultMessage
        return ResponseEntity.ok(ResponseModel(true, error))
    }

    @ExceptionHandler(Exception::class)
    fun handle(
        ex: Exception?,
        request: HttpServletRequest?, response: HttpServletResponse?
    ): ResponseEntity<Any>{
        return ResponseEntity.ok(ResponseModel(true, ex?.localizedMessage))
    }
}
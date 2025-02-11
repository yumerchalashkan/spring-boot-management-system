package com.it4us.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<?> userExist(UserExistException userExistException) {
        ErrorResponse errorResponse = new ErrorResponse(userExistException.getMessage(), 403);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("internal server error", 500);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WorkspaceExistException.class)
    public ResponseEntity<?> workspaceExist(WorkspaceExistException workspaceExistException) {
        ErrorResponse errorResponse = new ErrorResponse("workspace is already exist", 403);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException badRequestException) {
        ErrorResponse errorResponse = new ErrorResponse(badRequestException.getMessage(), 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), 404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BoardExistException.class)
    public ResponseEntity<?> boardExist(BoardExistException boardExistException) {
        ErrorResponse errorResponse = new ErrorResponse("board is already exist", 403);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<?> unAuthorized(UnAuthorizedException unAuthorizedException) {
        ErrorResponse errorResponse = new ErrorResponse("Unauthorized exception", 401);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(WorkspaceNotFoundException.class)
    public ResponseEntity<?> workspaceNotFound(WorkspaceNotFoundException workspaceNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(workspaceNotFoundException.getMessage(), 404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WorkspaceBelongAnotherUserException.class)
    public ResponseEntity<?> workspaceBelongedAnotherUser(WorkspaceBelongAnotherUserException workspaceBelongAnotherUserException) {
        ErrorResponse errorResponse = new ErrorResponse(workspaceBelongAnotherUserException.getMessage(), 401);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNameExistException.class)
    public ResponseEntity<?> userNameExist(UserNameExistException userNameExistException){
        ErrorResponse errorResponse = new ErrorResponse(userNameExistException.getMessage(),403);
        return new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    // to catch cast exception in @PathVariable when type is wrong passed.
    public ResponseEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        ErrorResponse errorResponse = new ErrorResponse(methodArgumentTypeMismatchException.getMessage(), 400);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BoardBelongAnotherUserException.class)
    public ResponseEntity<?> boardBelongedAnotherUser(BoardBelongAnotherUserException boardBelongAnotherUserException) {
        ErrorResponse errorResponse = new ErrorResponse(boardBelongAnotherUserException.getMessage(), 401);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<?> boardNotFoundException(BoardNotFoundException boardNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(boardNotFoundException.getMessage(), 404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}



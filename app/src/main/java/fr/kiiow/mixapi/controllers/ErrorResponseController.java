package fr.kiiow.mixapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseController {

    // 4xx Client Error
    public <T> ResponseEntity<T> _400_Bad_Request(T result) {
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    public <T> ResponseEntity<T> _401_Unauthorized(T result) {
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

    public <T> ResponseEntity<T> _402_Payment_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.PAYMENT_REQUIRED);
    }

    public <T> ResponseEntity<T> _403_Forbidden(T result) {
        return new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
    }

    public <T> ResponseEntity<T> _404_Not_Found(T result) {
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    public <T> ResponseEntity<T> _405_Method_Not_Allowed(T result) {
        return new ResponseEntity<>(result, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public <T> ResponseEntity<T> _406_Not_Acceptable(T result) {
        return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);
    }

    public <T> ResponseEntity<T> _407_Proxy_Authentication_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public <T> ResponseEntity<T> _408_Request_Timeout(T result) {
        return new ResponseEntity<>(result, HttpStatus.REQUEST_TIMEOUT);
    }

    public <T> ResponseEntity<T> _409_Conflict(T result) {
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    public <T> ResponseEntity<T> _410_Gone(T result) {
        return new ResponseEntity<>(result, HttpStatus.GONE);
    }

    public <T> ResponseEntity<T> _411_Length_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.LENGTH_REQUIRED);
    }

    public <T> ResponseEntity<T> _412_Precondition_Failed(T result) {
        return new ResponseEntity<>(result, HttpStatus.PRECONDITION_FAILED);
    }

    public <T> ResponseEntity<T> _413_Payload_Too_Large(T result) {
        return new ResponseEntity<>(result, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @Deprecated
    public <T> ResponseEntity<T> _413_Request_Entity_Too_Large(T result) {
        return new ResponseEntity<>(result, HttpStatus.REQUEST_ENTITY_TOO_LARGE);
    }

    public <T> ResponseEntity<T> _414_URI_Too_Long(T result) {
        return new ResponseEntity<>(result, HttpStatus.URI_TOO_LONG);
    }

    @Deprecated
    public <T> ResponseEntity<T> _414_RequestURI_Too_Long(T result) {
        return new ResponseEntity<>(result, HttpStatus.REQUEST_URI_TOO_LONG);
    }

    public <T> ResponseEntity<T> _415_Unsupported_Media_Type(T result) {
        return new ResponseEntity<>(result, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public <T> ResponseEntity<T> _416_Requested_range_not_satisfiable(T result) {
        return new ResponseEntity<>(result, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public <T> ResponseEntity<T> _417_Expectation_Failed(T result) {
        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }

    public <T> ResponseEntity<T> _418_I_m_a_teapot(T result) {
        return new ResponseEntity<>(result, HttpStatus.I_AM_A_TEAPOT);
    }

    @Deprecated
    public <T> ResponseEntity<T> _419_Insufficient_Space_On_Resource(T result) {
        return new ResponseEntity<>(result, HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE);
    }

    @Deprecated
    public <T> ResponseEntity<T> _420_Method_Failure(T result) {
        return new ResponseEntity<>(result, HttpStatus.METHOD_FAILURE);
    }

    @Deprecated
    public <T> ResponseEntity<T> _421_Destination_Locked(T result) {
        return new ResponseEntity<>(result, HttpStatus.DESTINATION_LOCKED);
    }

    public <T> ResponseEntity<T> _422_Unprocessable_Entity(T result) {
        return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public <T> ResponseEntity<T> _423_Locked(T result) {
        return new ResponseEntity<>(result, HttpStatus.LOCKED);
    }

    public <T> ResponseEntity<T> _424_Failed_Dependency(T result) {
        return new ResponseEntity<>(result, HttpStatus.FAILED_DEPENDENCY);
    }

    public <T> ResponseEntity<T> _425_Too_Early(T result) {
        return new ResponseEntity<>(result, HttpStatus.TOO_EARLY);
    }

    public <T> ResponseEntity<T> _426_Upgrade_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.UPGRADE_REQUIRED);
    }

    public <T> ResponseEntity<T> _428_Precondition_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.PRECONDITION_REQUIRED);
    }

    public <T> ResponseEntity<T> _429_Too_Many_Requests(T result) {
        return new ResponseEntity<>(result, HttpStatus.TOO_MANY_REQUESTS);
    }

    public <T> ResponseEntity<T> _431_Request_Header_Fields_Too_Large(T result) {
        return new ResponseEntity<>(result, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public <T> ResponseEntity<T> _451_Unavailable_For_Legal_Reasons(T result) {
        return new ResponseEntity<>(result, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    // 5xx Server Error
    public <T> ResponseEntity<T> _500_Internal_Server_Error(T result) {
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public <T> ResponseEntity<T> _501_Not_Implemented(T result) {
        return new ResponseEntity<>(result, HttpStatus.NOT_IMPLEMENTED);
    }

    public <T> ResponseEntity<T> _502_Bad_Gateway(T result) {
        return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
    }

    public <T> ResponseEntity<T> _503_Service_Unavailable(T result) {
        return new ResponseEntity<>(result, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public <T> ResponseEntity<T> _504_Gateway_Timeout(T result) {
        return new ResponseEntity<>(result, HttpStatus.GATEWAY_TIMEOUT);
    }

    public <T> ResponseEntity<T> _505_HTTP_Version_not_supported(T result) {
        return new ResponseEntity<>(result, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public <T> ResponseEntity<T> _506_Variant_Also_Negotiates(T result) {
        return new ResponseEntity<>(result, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public <T> ResponseEntity<T> _507_Insufficient_Storage(T result) {
        return new ResponseEntity<>(result, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public <T> ResponseEntity<T> _509_Bandwidth_Limit_Exceeded(T result) {
        return new ResponseEntity<>(result, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public <T> ResponseEntity<T> _510_Not_Extended(T result) {
        return new ResponseEntity<>(result, HttpStatus.NOT_EXTENDED);
    }

    public <T> ResponseEntity<T> _511_Network_Authentication_Required(T result) {
        return new ResponseEntity<>(result, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}

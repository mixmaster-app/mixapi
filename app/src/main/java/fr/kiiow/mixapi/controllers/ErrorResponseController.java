package fr.kiiow.mixapi.controllers;

import fr.kiiow.mixapi.models.rest.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseController {

    // 4xx Client Error
    public ResponseEntity<DefaultResponse> _400_Bad_Request(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<DefaultResponse> _401_Unauthorized(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<DefaultResponse> _402_Payment_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.PAYMENT_REQUIRED);
    }

    public ResponseEntity<DefaultResponse> _403_Forbidden(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<DefaultResponse> _404_Not_Found(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DefaultResponse> _405_Method_Not_Allowed(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.METHOD_NOT_ALLOWED);
    }

    public ResponseEntity<DefaultResponse> _406_Not_Acceptable(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<DefaultResponse> _407_Proxy_Authentication_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public ResponseEntity<DefaultResponse> _408_Request_Timeout(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.REQUEST_TIMEOUT);
    }

    public ResponseEntity<DefaultResponse> _409_Conflict(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.CONFLICT);
    }

    public ResponseEntity<DefaultResponse> _410_Gone(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.GONE);
    }

    public ResponseEntity<DefaultResponse> _411_Length_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.LENGTH_REQUIRED);
    }

    public ResponseEntity<DefaultResponse> _412_Precondition_Failed(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.PRECONDITION_FAILED);
    }

    public ResponseEntity<DefaultResponse> _413_Payload_Too_Large(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @Deprecated
    public ResponseEntity<DefaultResponse> _413_Request_Entity_Too_Large(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.REQUEST_ENTITY_TOO_LARGE);
    }

    public ResponseEntity<DefaultResponse> _414_URI_Too_Long(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.URI_TOO_LONG);
    }

    @Deprecated
    public ResponseEntity<DefaultResponse> _414_RequestURI_Too_Long(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.REQUEST_URI_TOO_LONG);
    }

    public ResponseEntity<DefaultResponse> _415_Unsupported_Media_Type(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<DefaultResponse> _416_Requested_range_not_satisfiable(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public ResponseEntity<DefaultResponse> _417_Expectation_Failed(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.EXPECTATION_FAILED);
    }

    public ResponseEntity<DefaultResponse> _418_I_m_a_teapot(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.I_AM_A_TEAPOT);
    }

    @Deprecated
    public ResponseEntity<DefaultResponse> _419_Insufficient_Space_On_Resource(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE);
    }

    @Deprecated
    public ResponseEntity<DefaultResponse> _420_Method_Failure(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.METHOD_FAILURE);
    }

    @Deprecated
    public ResponseEntity<DefaultResponse> _421_Destination_Locked(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.DESTINATION_LOCKED);
    }

    public ResponseEntity<DefaultResponse> _422_Unprocessable_Entity(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity<DefaultResponse> _423_Locked(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.LOCKED);
    }

    public ResponseEntity<DefaultResponse> _424_Failed_Dependency(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.FAILED_DEPENDENCY);
    }

    public ResponseEntity<DefaultResponse> _425_Too_Early(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.TOO_EARLY);
    }

    public ResponseEntity<DefaultResponse> _426_Upgrade_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.UPGRADE_REQUIRED);
    }

    public ResponseEntity<DefaultResponse> _428_Precondition_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.PRECONDITION_REQUIRED);
    }

    public ResponseEntity<DefaultResponse> _429_Too_Many_Requests(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.TOO_MANY_REQUESTS);
    }

    public ResponseEntity<DefaultResponse> _431_Request_Header_Fields_Too_Large(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public ResponseEntity<DefaultResponse> _451_Unavailable_For_Legal_Reasons(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
    }

    // 5xx Server Error
    public ResponseEntity<DefaultResponse> _500_Internal_Server_Error(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<DefaultResponse> _501_Not_Implemented(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DefaultResponse> _502_Bad_Gateway(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<DefaultResponse> _503_Service_Unavailable(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.SERVICE_UNAVAILABLE);
    }

    public ResponseEntity<DefaultResponse> _504_Gateway_Timeout(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.GATEWAY_TIMEOUT);
    }

    public ResponseEntity<DefaultResponse> _505_HTTP_Version_not_supported(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public ResponseEntity<DefaultResponse> _506_Variant_Also_Negotiates(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public ResponseEntity<DefaultResponse> _507_Insufficient_Storage(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.INSUFFICIENT_STORAGE);
    }

    public ResponseEntity<DefaultResponse> _509_Bandwidth_Limit_Exceeded(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public ResponseEntity<DefaultResponse> _510_Not_Extended(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.NOT_EXTENDED);
    }

    public ResponseEntity<DefaultResponse> _511_Network_Authentication_Required(String message) {
        return new ResponseEntity<>(new DefaultResponse(message), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}

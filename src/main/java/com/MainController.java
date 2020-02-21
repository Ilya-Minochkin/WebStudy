package com;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class MainController {

    private static final String SUCCES_STATUS = "succes";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCES = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public Response showStatus(){
        return new Response(SUCCES_STATUS, 1);
    }

    @PostMapping("/pay")
    public Response pay(@RequestParam(value="key") String key, @RequestBody Users users) {
        final Response response;


        response = new Response(SUCCES_STATUS, CODE_SUCCES);
        return response;
    }
}

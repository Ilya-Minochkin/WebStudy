package controllers;


import entites.BaseResponse;
import entites.PaymentRequest;
import entites.Users;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class MainController {

    public static final String sharedKey = "SHARED_KEY";
    private static final String SUCCES_STATUS = "succes";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCES = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus(){
        return new BaseResponse(SUCCES_STATUS, 1);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value="SHARED_KEY") String key, @RequestBody PaymentRequest request) {
        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();

            response = new BaseResponse(SUCCES_STATUS, CODE_SUCCES);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}

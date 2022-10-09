package antifraud.controller;

import antifraud.model.Response;
import antifraud.model.Transaction;
import antifraud.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/antifraud")
public class FraudController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Response> transaction(@RequestBody Transaction transaction) {
        Response response = transactionService.checkTransaction(transaction);
        switch (response.getResult()) {
            case "ALLOWED":
            case "MANUAL_PROCESSING":
            case "PROHIBITED":
                return ResponseEntity.ok(response);
            case "BAD_REQUEST":
                return ResponseEntity.status(400).body(response);
            default:
                return ResponseEntity.status(500).body(response);
        }
    }
}

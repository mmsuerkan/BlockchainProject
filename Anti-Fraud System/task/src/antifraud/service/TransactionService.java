package antifraud.service;

import antifraud.model.Response;
import antifraud.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    public Response checkTransaction(Transaction transaction) {

        if (transaction.getAmount() == null) {
            return new Response("BAD_REQUEST");
        } else {
            if (transaction.getAmount() <= 0) {
                return new Response("BAD_REQUEST");
            } else if (transaction.getAmount() <= 200) {
                return new Response("ALLOWED");
            } else if (transaction.getAmount() > 200 && transaction.getAmount() <= 1500) {
                return new Response("MANUAL_PROCESSING");
            } else {
                return new Response("PROHIBITED");
            }
        }

    }
}

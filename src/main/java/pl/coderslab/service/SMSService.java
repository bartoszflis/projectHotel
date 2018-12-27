package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Guest;
import pl.coderslab.repository.GuestRepository;
import pl.smsapi.BasicAuthClient;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.api.action.sms.SMSSend;
import pl.smsapi.api.response.MessageResponse;
import pl.smsapi.api.response.StatusResponse;
import pl.smsapi.exception.ClientException;
import pl.smsapi.exception.SmsapiException;


@Component
public class SMSService {


    public boolean Send(String phoneNumber, String text) {
        boolean success = false;
        try {
            BasicAuthClient client = new BasicAuthClient("adam910702@gmail.com", "6c5343230532bf5e4b72ca2a790d3acd");

            SmsFactory smsApi = new SmsFactory(client);
            SMSSend action = smsApi.actionSend()
                    .setText(text)
                    .setTo(phoneNumber);

            StatusResponse result = action.execute();

            for (MessageResponse status : result.getList() ) {
                System.out.println(status.getNumber() + " " + status.getStatus());
            }
            success = true;
        } catch (ClientException e) {
            /**
             * 101 Niepoprawne lub brak danych autoryzacji.
             * 102 Nieprawidłowy login lub hasło
             * 103 Brak punków dla tego użytkownika
             * 105 Błędny adres IP
             * 110 Usługa nie jest dostępna na danym koncie
             * 1000 Akcja dostępna tylko dla użytkownika głównego
             * 1001 Nieprawidłowa akcja
             */
            e.printStackTrace();
        } catch (SmsapiException e) {
            e.printStackTrace();
        }

        return success;
    }



}

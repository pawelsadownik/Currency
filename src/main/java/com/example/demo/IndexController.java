package com.example.demo;


import com.example.demo.calculations.CalculateCurrency;
import com.example.demo.model.CurrencyData;
import com.example.demo.model.InputData;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;


@Controller
public class IndexController {


    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/";

    @GetMapping ("/index")
    public String getIndex(Model model)  {

        model.addAttribute("inputData", new InputData());
        return "index";
    }

    @PostMapping("/index")
    public String getResult (@ModelAttribute CurrencyData currencyData, InputData inputData, Model model){

       String newURL = new StringBuilder()
                .append(URL)
                .append(inputData.getCode())
                .append("/")
                .append(inputData.getBeginDate())
                .append("/")
                .append(inputData.getEndDate())
                .toString();

        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(httpHeaders);

        try {
            ResponseEntity<CurrencyData> response = restTemplate.exchange(newURL, HttpMethod.GET, entity, CurrencyData.class);
            CurrencyData currencyDataResponseBody  = response.getBody();
            CalculateCurrency calculateCurrency = new CalculateCurrency();

            BigDecimal avegareBidRate = calculateCurrency.getAverageBidRate(currencyDataResponseBody);
            BigDecimal standardDeviationAsk = calculateCurrency.getStandardDeviationAsk(currencyDataResponseBody);

            String code = currencyDataResponseBody.getCode();

            model.addAttribute("average", avegareBidRate);
            model.addAttribute("deviation",standardDeviationAsk);
            model.addAttribute("code", code);
        }
            catch (Exception exception){
            return "apifailure";
        }

        return "result";
    }


}
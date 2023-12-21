package com.liana.bigsum.endpoint.rest.controller.health;

import com.liana.bigsum.repository.DummyRepository;
import com.liana.bigsum.repository.DummyUuidRepository;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BigSumController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;

  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/big-sum")
    public String getSum(@RequestParam("a") String a,
                      @RequestParam("b") String b) {
        try {
            BigInteger first = new BigInteger(a);
            BigInteger second = new BigInteger(b);

            BigInteger sum = first.add(second);

            return "Voici la somme: " + sum;
        } catch (NumberFormatException e) {
            return "Nombres invalides";
        }
    }
}

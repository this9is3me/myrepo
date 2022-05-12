package com.github.this9is3me;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class QuoteController {
    @GetMapping
    String getQuote(Model model) {
        model.addAttribute("quote", dynamicGenerator());
        return "index";
    }

    String dynamicGenerator() {
        List<String> quotes = Arrays.asList(
                "Logic will get you from A to B. Imagination will take you everywhere.",
                "There are 10 kinds of people. Those who know binary and those who don't.",
                "There are two ways of constructing a software design. One way is to make it so simple that there are obviously no deficiencies and the other is to make it so complicated that there are no obvious deficiencies.",
                "It's not that I'm so smart, it's just that I stay with problems longer.",
                "It is pitch dark. You are likely to be eaten by a grue.");
        Random rand = new Random();
        return quotes.get(rand.nextInt(quotes.size()));
    }
}

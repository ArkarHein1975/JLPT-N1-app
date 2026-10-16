package com.example.jlptn1app.controller;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import com.example.jlptn1app.repository.UserRepository;
import com.example.jlptn1app.model.User;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jlptn1app.model.OnomatopoeiaWord;
import com.example.jlptn1app.repository.OnomatopoeiaWordRepository;

import com.example.jlptn1app.model.UsageWord;
import com.example.jlptn1app.repository.UsageWordRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jlptn1app.model.ContextWord;
import com.example.jlptn1app.model.KanjiWord;
import com.example.jlptn1app.model.SynonymWord;
import com.example.jlptn1app.repository.ContextWordRepository;
import com.example.jlptn1app.repository.KanjiWordRepository;
import com.example.jlptn1app.repository.SynonymWordRepository;

@Controller
public class PageController {

    private final KanjiWordRepository kanjiWordRepository;
    private final ContextWordRepository contextWordRepository;
    private final SynonymWordRepository synonymWordRepository;
    private final UsageWordRepository usageWordRepository;
    private final OnomatopoeiaWordRepository onomatopoeiaWordRepository;
    private final UserRepository userRepository;
    public PageController(
            KanjiWordRepository kanjiWordRepository,
            ContextWordRepository contextWordRepository,
            SynonymWordRepository synonymWordRepository,
            UsageWordRepository usageWordRepository,
            OnomatopoeiaWordRepository onomatopoeiaWordRepository,
            UserRepository userRepository
            
        ) {

        this.kanjiWordRepository = kanjiWordRepository;
        this.contextWordRepository = contextWordRepository;
        this.synonymWordRepository = synonymWordRepository;
        this.usageWordRepository = usageWordRepository;
        this.onomatopoeiaWordRepository = onomatopoeiaWordRepository;
        this.userRepository = userRepository;
        
    }
    @GetMapping("/register")
public String registerPage() {
    return "register";
}
@GetMapping("/user-login")
public String userLoginPage() {
    return "user-login";
}

    @GetMapping("/")
    public String login() {
        return "login";
    }

   @GetMapping("/category")
public String category(HttpSession session) {

    Long userId = (Long) session.getAttribute("userId");

    if (userId == null) {
        return "redirect:/user-login";
    }

    return "category";
}

    // 第1章
    @GetMapping("/chapter1")
    public String chapter1(
            @RequestParam(defaultValue = "0") int page,
            Model model, HttpSession session) {
                Long userId = (Long) session.getAttribute("userId");

if (userId == null) {
    return "redirect:/user-login";
}
        int pageSize = 20;

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<KanjiWord> wordPage =
                kanjiWordRepository.findByChapterOrderById(1, pageable);

        model.addAttribute("words", wordPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", wordPage.hasNext());
        model.addAttribute("hasPrevious", wordPage.hasPrevious());
        model.addAttribute("totalPages", wordPage.getTotalPages());

        return "chapter1";
    }

    // 第2章
    @GetMapping("/chapter2")
    public String chapter2(
            @RequestParam(defaultValue = "0") int page,
            Model model, HttpSession session) {
                Long userId = (Long) session.getAttribute("userId");

if (userId == null) {
    return "redirect:/user-login";
}

        int pageSize = 10;

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<ContextWord> wordPage =
                contextWordRepository.findAllByOrderById(pageable);

        model.addAttribute("words", wordPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", wordPage.hasNext());
        model.addAttribute("hasPrevious", wordPage.hasPrevious());
        model.addAttribute("totalPages", wordPage.getTotalPages());

        return "chapter2";
    }

    // 第3章
    @GetMapping("/chapter3")
    public String chapter3(
            @RequestParam(defaultValue = "0") int page,
            Model model, HttpSession session) {
                Long userId = (Long) session.getAttribute("userId");

if (userId == null) {
    return "redirect:/user-login";
}

        int pageSize = 9;

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<SynonymWord> wordPage =
                synonymWordRepository.findAllByOrderById(pageable);

        model.addAttribute("words", wordPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", wordPage.hasNext());
        model.addAttribute("hasPrevious", wordPage.hasPrevious());
        model.addAttribute("totalPages", wordPage.getTotalPages());

        return "chapter3";
    }
    // 第4章
@GetMapping("/chapter4")
public String chapter4(
        @RequestParam(defaultValue = "0") int page,
        Model model, HttpSession session) {
            Long userId = (Long) session.getAttribute("userId");

if (userId == null) {
    return "redirect:/user-login";
}

    int pageSize = 10;

    Pageable pageable = PageRequest.of(page, pageSize);

    Page<UsageWord> wordPage =
            usageWordRepository.findAllByOrderById(pageable);

    model.addAttribute("words", wordPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("hasNext", wordPage.hasNext());
    model.addAttribute("hasPrevious", wordPage.hasPrevious());
    model.addAttribute("totalPages", wordPage.getTotalPages());

    return "chapter4";
}
// 第5章
@GetMapping("/chapter5")
public String chapter5(
        @RequestParam(defaultValue = "0") int page,
        Model model, HttpSession session) {
            Long userId = (Long) session.getAttribute("userId");

if (userId == null) {
    return "redirect:/user-login";
}

    int pageSize = 21;

    Pageable pageable = PageRequest.of(page, pageSize);

    Page<OnomatopoeiaWord> wordPage =
            onomatopoeiaWordRepository.findAllByOrderById(pageable);

    model.addAttribute("words", wordPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("hasNext", wordPage.hasNext());
    model.addAttribute("hasPrevious", wordPage.hasPrevious());
    model.addAttribute("totalPages", wordPage.getTotalPages());

    return "chapter5";
}
@PostMapping("/register")
public String register(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password) {

    User user = new User(name, email, password);

    userRepository.save(user);

    return "redirect:/user-login";
}
@PostMapping("/user-login")
public String userLogin(
        @RequestParam String email,
        @RequestParam String password,
        HttpSession session) {

    Optional<User> user = userRepository.findByEmail(email);

    if (user.isPresent()
            && user.get().getPassword().equals(password)) {

        session.setAttribute("userId", user.get().getId());
        session.setAttribute("userName", user.get().getName());

        return "redirect:/category";

    } else {

        return "redirect:/user-login?error=true";
    }
}
@GetMapping("/logout")
public String logout(HttpSession session) {

    session.invalidate();

    return "redirect:/user-login";
}

}
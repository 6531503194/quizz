// package com.edtech.quizz.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

// import com.edtech.quizz.Repo.FlashcardRepo;
// import com.edtech.quizz.Model.*;


// @Controller
// public class SearchController {

//     @Autowired
//     private FlashcardRepo flashcardRepository;

//     @GetMapping("/search-card")
//     public String search(@RequestParam(required = false, defaultValue = "") String keyword, Model model) {
//         List<Flashcard> searchResults = List.of();

//         if (!keyword.isEmpty()) {
//             // Fetch the first matching keyword from the suggestions
//             List<String> suggestions = flashcardRepository.findKeywordsByFlexibleSearch(keyword);
//             if (!suggestions.isEmpty()) {
//                 keyword = suggestions.get(0); // Use the first suggestion as the keyword
//                 searchResults = flashcardRepository.searchFlashcards(keyword);
//             }
//         }

//         model.addAttribute("searchResults", searchResults);
//         model.addAttribute("keyword", keyword);

//         return "search_card";
//     }

//     @ResponseBody
//     @GetMapping("/suggest-keywords")
//     public List<String> suggestKeywords(@RequestParam String prefix) {
//         return flashcardRepository.findKeywordsByFlexibleSearch(prefix);
//     }


// }

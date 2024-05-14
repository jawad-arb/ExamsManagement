//package com.arbahi.examsmanagement.restController;
//
//import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
//import com.arbahi.examsmanagement.entity.PedagogicalElement;
//import com.arbahi.examsmanagement.service.PedagogicalElementService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/elements")
//@RequiredArgsConstructor
//public class PedagogicalElementController {
//
//    private final PedagogicalElementService pedagogicalElementService;
//
//    @PostMapping
//    public ResponseEntity<PedagogicalElementDTO> createElement(@Valid @RequestBody PedagogicalElement pedagogicalElement) {
//        PedagogicalElementDTO createdElement = pedagogicalElementService.addElement(pedagogicalElement);
//        return new ResponseEntity<>(createdElement, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{elementId}")
//    public ResponseEntity<PedagogicalElementDTO> getElementById(@PathVariable Integer elementId) {
//        PedagogicalElementDTO elementDTO = pedagogicalElementService.getElementById(elementId);
//        if (elementDTO != null) {
//            return ResponseEntity.ok(elementDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{elementId}")
//    public ResponseEntity<PedagogicalElementDTO> updateElement(@PathVariable Integer elementId, @Valid @RequestBody PedagogicalElement updatedElement) {
//        PedagogicalElementDTO updatedElementDTO = pedagogicalElementService.updateElement(elementId, updatedElement);
//        if (updatedElementDTO != null) {
//            return ResponseEntity.ok(updatedElementDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{elementId}")
//    public ResponseEntity<Void> deleteElement(@PathVariable Integer elementId) {
//        pedagogicalElementService.removeElement(elementId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PedagogicalElementDTO>> getAllElements() {
//        List<PedagogicalElementDTO> elements = pedagogicalElementService.getAllElements();
//        return ResponseEntity.ok(elements);
//    }
//}

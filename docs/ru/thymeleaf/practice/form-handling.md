# Обработка Формы

**Описание:**

В этом продолжении мы сосредоточимся на обработке отправки форм и отображении представления с использованием `PracticeController`. Это включает передачу модели в представление при его отображении и реализацию логики обработки отправки формы.

**Шаги:**

1. **Отображение Представления Формы (PracticeController):**

   - Откройте класс `PracticeController` и добавьте метод для отображения представления формы:

     ```java
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.GetMapping;

     @Controller
     public class PracticeController {

         // Другие методы...

         @GetMapping("/third")
         public String showAddStudentForm(Model model) {
             model.addAttribute("model", new StudentModel());
             return "practice/third";
         }
     }
     ```

   - Объяснение:
      - `@GetMapping("/third")`: Эта аннотация сопоставляет метод с обработкой GET-запросов для конечной точки `/third`.
      - `showAddStudentForm(Model model)`: Этот метод принимает параметр `Model`, добавляет в него новый объект `StudentModel` и возвращает имя представления (`"thirdView"` в данном случае). Обновлено для отражения правильного названия представления.
      - Модель заполняется новым экземпляром `StudentModel`, который будет использоваться для привязки полей формы.

2. **Обработка Отправки Формы (PracticeController):**

   - Добавьте метод в `PracticeController` для обработки отправки формы:

     ```java
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.*;

     import java.util.ArrayList;
     import java.util.List;

     @Controller
     public class PracticeController {

         private final List<StudentModel> students = new ArrayList<>();

         // Другие методы...

         @PostMapping("/addStudent")
         public String addStudent(@ModelAttribute("model") StudentModel model) {
             students.add(model);

             return "redirect:/third";
         }
     }
     ```

   - Объяснение:
      - `@PostMapping("/addStudent")`: Эта аннотация сопоставляет метод с обработкой POST-запросов для конечной точки `/addStudent`.
      - `addStudent(@ModelAttribute("model") StudentModel model)`: Этот метод принимает атрибут `model` из отправленной формы (`@ModelAttribute`) и обрабатывает его. Данные формы автоматически привязываются к объекту `model`.
      - Логика внутри этого метода добавляет студента в список `students`. В реальном сценарии вы обычно бы сохраняли студента в базу данных или выполняли другие необходимые действия.
      - `return "redirect:/third";`: Эта строка перенаправляет пользователя обратно к представлению формы (`/third`).

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: *Параметры Запроса и Валидация*](validation.md)
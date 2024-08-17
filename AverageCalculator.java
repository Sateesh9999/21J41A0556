import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AverageCalculator {

    @PostMapping("/average")
    public ResponseEntity<Double> calculateAverage(@RequestBody List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        double average = sum / numbers.size();

        return ResponseEntity.ok(average);
    }
}
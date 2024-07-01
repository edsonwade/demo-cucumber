package code.with.vanilson.cucumber.space.alien;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


import java.math.BigDecimal;
/**
 * Alien
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */


@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(value = {WeightIncreaseEntityListener.class})
@Slf4j
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String fullName;
    private int weight;
    private BigDecimal runSpeed;
    //    runSpeed
    private int height;

    public String beamUp(String something) {
        String beaming = String.format("Woppa woppa woppa we are beaming up %s", something);
        log.info(beaming);
        return beaming;
    }

    public Alien(String type, String fullName, int weight, BigDecimal runSpeed, int height) {
        this.type = type;
        this.fullName = fullName;
        this.weight = weight;
        this.runSpeed = runSpeed;
        this.height = height;
    }
}
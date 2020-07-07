package dyliang.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Player {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float salary;
}

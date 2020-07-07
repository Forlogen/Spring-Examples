package dyliang.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    @Getter
    @Setter
    public Integer id;

    @Getter
    @Setter
    private String name;


}

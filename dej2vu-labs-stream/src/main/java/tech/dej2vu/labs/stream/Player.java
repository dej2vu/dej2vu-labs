package tech.dej2vu.labs.stream;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author dej2vu
 * @date 2023/08/08
 */
@Data
@Builder
public class Player {

    @Tolerate
    public Player(){}

    private Team team;

    private Position position;

    private String nickname;

    private Integer score;

    public String getUnionKey(){
        return String.format("%s.%s", team, nickname);
    }

}

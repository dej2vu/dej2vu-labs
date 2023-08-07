package tech.dej2vu.labs.easyexcel;

import lombok.Getter;

import java.lang.constant.DynamicConstantDesc;
import java.util.Arrays;
import java.util.Objects;

@Getter
public enum Gender {
    MALE("男"),
    FEMALE("女");

    Gender(String desc){
        this.desc = desc;
    }

    private final String desc;

    public static Gender descOf(String desc){
        return Arrays.stream(Gender.values())
                .filter(e -> Objects.equals(e.getDesc(), desc))
                .findFirst()
                .orElse(null);
    }

}

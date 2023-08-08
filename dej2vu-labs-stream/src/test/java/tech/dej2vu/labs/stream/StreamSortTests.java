package tech.dej2vu.labs.stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tech.dej2vu.labs.stream.Position.*;
import static tech.dej2vu.labs.stream.Team.*;

/**
 *
 * @author edc
 * @date 2023/08/08
 */
public class StreamSortTests {

    @Test
    public void sort_test(){

        List<Player> players = given();
        System.out.println("原始数据：");
        players.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Player> dedupedPlayers = dedup(players);
        System.out.println("去重后数据：");
        dedupedPlayers.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Player> sortedPlayers = dedupedPlayers.stream()
                .sorted(Comparator.comparing(Player::getTeam).thenComparing(Player::getScore, Comparator.reverseOrder()))
                .toList();
        System.out.println("去重再排序的数据：");
        sortedPlayers.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Player> distinctSortedAndPlayers1 = dedupAndSort_1(players);
        System.out.println("去重并排序的数据：");
        distinctSortedAndPlayers1.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Player> distinctSortedAndPlayers2 = dedupAndSort_2(players);
        System.out.println("去重并排序的数据：");
        distinctSortedAndPlayers2.forEach(System.out::println);

    }

    private static List<Player> dedup(List<Player> players){
        return players.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(Player::getUnionKey))),
                        ArrayList::new));
    }


    private static List<Player> dedupAndSort_1(List<Player> players){
        return players.stream()
                .filter(distinctByKey(Player::getUnionKey))
                .sorted(Comparator.comparing(Player::getTeam).thenComparing(Player::getScore, Comparator.reverseOrder()))
                .toList();
    }

    private static List<Player> dedupAndSort_2(List<Player> players){

        Predicate<Player> distinctByUnionKey = new Predicate<>() {
            final Map<Object, Boolean> seen = new ConcurrentHashMap<>();
            @Override
            public boolean test(Player player) {
                return seen.putIfAbsent(player.getUnionKey(), Boolean.TRUE) == null;
            }
        };

        return players.stream()
                .filter(distinctByUnionKey)
                .sorted(Comparator.comparing(Player::getTeam).thenComparing(Player::getScore, Comparator.reverseOrder()))
                .toList();
    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }

    private List<Player> given(){

        Player uzi = Player.builder().team(LEGEND).position(BOT).nickname("UZI").score(103).build();
        Player clearlove = Player.builder().team(LEGEND).position(JUG).nickname("Clearlove").score(103).build();
        Player scout = Player.builder().team(EDG).position(MID).nickname("Scout").score(97).build();
        Player flandre = Player.builder().team(EDG).position(TOP).nickname("Flandre").score(95).build();
        Player meiko = Player.builder().team(EDG).position(SUP).nickname("Meiko").score(94).build();
        Player tian = Player.builder().team(FPX).position(JUG).nickname("Tian").score(97).build();
        Player doinb = Player.builder().team(FPX).position(MID).nickname("Doinb").score(96).build();
        Player crisp = Player.builder().team(FPX).position(SUP).nickname("Crisp").score(95).build();
        Player ning = Player.builder().team(IG).position(JUG).nickname("Ning").score(97).build();
        Player theShy = Player.builder().team(IG).position(TOP).nickname("TheShy").score(95).build();
        Player rookie = Player.builder().team(IG).position(MID).nickname("Rookie").score(95).build();
        Player jackeyLove = Player.builder().team(IG).position(BOT).nickname("JackeyLove").score(95).build();
        Player baolan = Player.builder().team(IG).position(SUP).nickname("Baolan").score(94).build();

        List<Player> players = Lists.list(uzi, clearlove, scout, flandre, meiko, tian, doinb, crisp, ning, theShy, rookie, jackeyLove, baolan);
        List<Player> duplicated = Lists.list(uzi, clearlove, scout, flandre, meiko);

        return Stream.of(players, duplicated).flatMap(Collection::stream).collect(Collectors.toList());
    }

}

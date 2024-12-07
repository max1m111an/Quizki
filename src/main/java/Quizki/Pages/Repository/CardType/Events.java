package Quizki.Pages.Repository.CardType;

import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  Реализация класса обработки событий функционального
 *  окна прохождения карточек (см. CardType)
 */

public class Events {

    // Переход на окно репозитория
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_wrong = new ArrayList<>();
            Repository.arr_corr = new ArrayList<>();
            Repository.card_count = 1;
            Repository.cur_card = Repository.arr_cards.getFirst();

            Main.temp.setScene(Repository.repos_p.getScene());
        }
    }

    // Засчитать ответ, как неправильный
    static class CorrectAnswer implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_corr.add(Repository.cur_card);
            Repository.card_count++;
            if (Repository.card_count == Repository.arr_cards.size() + 1){
                Result.changeScene();
                Main.temp.setScene(Result.scene);
                Result.b_continue.setDisable(Repository.arr_cards.equals(Repository.arr_corr));
            }else{
                Repository.cur_card = Repository.arr_cards.get(Repository.card_count - 1);
                CardType.b_card.setText(Repository.cur_card.getFace());
                CardType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
            }
        }
    }

    // Засчитать ответ, как неправильный
    static class WrongAnswer implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_wrong.add(Repository.cur_card);
            Repository.card_count++;
            if (Repository.card_count == Repository.arr_cards.size() + 1){
                Result.changeScene();
                Main.temp.setScene(Result.scene);
            }else {
                Repository.cur_card = Repository.arr_cards.get(Repository.card_count - 1);
                CardType.b_card.setText(Repository.cur_card.getFace());
                CardType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
            }
        }
    }

    // "Перевернуть" карточку (посмотреть ответ)
    static class FlipCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (CardType.b_card.getText().equals(Repository.cur_card.getFace())) CardType.b_card.setText(Repository.cur_card.getBack());
            else CardType.b_card.setText(Repository.cur_card.getFace());
        }
    }

    // Начать прохождение теста с неправильными ответами
    static class Continue implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_cards = Repository.arr_wrong;
            Collections.shuffle(Repository.arr_cards);

            Repository.arr_wrong = new ArrayList<>();
            Repository.arr_corr = new ArrayList<>();
            Repository.card_count = 1;
            CardType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
            Repository.cur_card = Repository.arr_cards.getFirst();
            CardType.b_card.setText(Repository.cur_card.getFace());
            Main.temp.setScene(CardType.card_type_p.getScene());
        }
    }

    // Начать прохождение теста заново
    static class Reset implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_cards = Repository.cur_collect.getCard_set();
            Collections.shuffle(Repository.arr_cards);

            Repository.arr_wrong = new ArrayList<>();
            Repository.arr_corr = new ArrayList<>();
            Repository.card_count = 1;
            CardType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
            Repository.cur_card = Repository.arr_cards.getFirst();
            CardType.b_card.setText(Repository.cur_card.getFace());
            Main.temp.setScene(CardType.card_type_p.getScene());
        }
    }

}

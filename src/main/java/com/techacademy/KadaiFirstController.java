package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.DayOfWeek;

@RestController
public class KadaiFirstController {

//    仕様１：指定日の曜日を算定する
    @GetMapping("dayofweek/{val1}")
//    メソッドの作成：　dispDayOfWeekメソッドを作成して、@PathVariableアノテーションを使って、URLのパスに含まれる「val1」を文字列として取得する
    public String dispDayOfWeek(@PathVariable String val1) {
//        インスタンスの作成：　DateTimeFormatter（クラス）を使用して、日付の形式を指定する
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

//        エラー処理：　try-、catchを使用してエラー処理を行う
        try {
//            メソッドの使用：　LocalDateのparseメソッドを使用して、「val1」を指定されたフォーマット(yyyyMMdd)で日付に変換する
            LocalDate date = LocalDate.parse(val1, formatter);
//            メソッドの使用：　getDayOfWeekメソッドを使って、yyyyMMdd形式で取得した「date(日付)」から曜日を取得する
            DayOfWeek dayOfWeek = date.getDayOfWeek();
//            変数の指定：　列挙型のdayOfWeekを文字列に変換する
            String day = dayOfWeek.toString();
//            変数の指定：　文字列に変換したdayOfWeekは全て大文字なので、charAtメソッドを使ってdayOfWeekの1文字目（大文字）を取得し、substringメソッドで2文字目以降を取得しtoLowerCaseで小文字化し、組み合わせる
            String weekName = day.charAt(0) + day.substring(1).toLowerCase();
//            仕様1のリターン：　weekName変数を取得して表示に返す
            return weekName;

//        エラー処理：　エラー発生時の動き
        } catch (DateTimeParseException e) {
//        LocalDate.paserでyyyyMMddに変換できない場合はエラーを返す
            return "エラー：20191231のようにyyyymmdd形式で入力してください。";
        }
    }

//    仕様2：四則演算を行う
//    足し算
    @GetMapping("plus/{val1}/{val2}")
//    メソッドの作成： calcPlusメソッドを作成する
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
//        変数の指定： int型のresを指定
        int res = 0;
//        変数の指定： val1とval2を足した値をresに指定
        res = val1 + val2;
//        resを戻す
        return res;
    }

//  　引き算
    @GetMapping("minus/{val1}/{val2}")
//    メソッドの作成： calcMinusメソッドを作成する
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
//     　 変数の指定： int型のresを指定
        int res = 0;
//    　  変数の指定： val1とval2を引き算した値をresに指定
        res = val1 - val2;
//    　  resを戻す
        return res;
    }

//  　掛け算
    @GetMapping("times/{val1}/{val2}")
//    メソッドの作成： calcTimesメソッドを作成する
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
//        変数の指定： int型のresを指定
        int res = 0;
//        変数の指定： val1とval2を掛け算した値をresに指定
        res = val1 * val2;
//        resを戻す
        return res;
    }

//    割り算
    @GetMapping("divide/{val1}/{val2}")
//    メソッドの作成： calcDivideメソッドを作成する
    public int calcDivide(@PathVariable int val1, @PathVariable int val2) {
//        変数の指定： int型のresを指定
        int res = 0;
//        変数の指定： val1とval2を掛け算した値をresに指定
        res = val1 / val2;
//        resを戻す
        return res;
    }

}

package by.vorokhobko.control;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * JsoupWork.
 *
 * Class JsoupWork for parser web site for 008, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.12.2017.
 * @version 1.
 */
public class JsoupWork {
    /**
     * The class field.
     */
    private static final String URL = "http://www.sql.ru/forum/job-offers";
    /**
     * The method parse web site and add element in database.
     * @param db - db.
     */
    public void addDatabaseElements(WorkDatabase db) {
        try {
            String vacancy, description, creates;
            Document doc = Jsoup.connect(URL).get();
            Elements topics = doc.select("tr:has(.postslisttopic)");
            for (Element topic : topics) {
                if (topic.text().toLowerCase().contains("java") & !topic.text().toLowerCase().contains("script")
                        & !topic.text().toLowerCase().contains("javascript")) {
                    Elements data = topic.select("td");
                    vacancy = data.get(2).text();
                    description = data.get(1).text();
                    creates = data.get(5).text();
                    db.add(vacancy, description, creates);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package org;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.search.SimpleQueryStringQueryParser;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2022/3/15
 * description:
 */
public class IKSegmenterTest {

//    static String text = "211工程";
    static String text = "中央高校建设世界一流大学（学科）和特色发展引导专项资金";

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration(true, false, true);

        //创建分词对象
        Analyzer anal = new IKAnalyzer(configuration);
        StringReader reader = new StringReader(text);
        //分词
        TokenStream ts = anal.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        ts.reset();
        while(ts.incrementToken()){
            System.out.print(term.toString() + "|");
        }
        reader.close();
        System.out.println();
    }

}

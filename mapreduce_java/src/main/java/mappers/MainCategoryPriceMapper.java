package mappers;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shared.Data;

import java.io.IOException;

public class MainCategoryPriceMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

    private static final Logger LOG = LoggerFactory.getLogger(MainCategoryPriceMapper.class);

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] lineData = line.split(Data.SEPARATOR);

        String[] categories = lineData[Data.CATEGORY].split("/");

        if(categories.length > 0) {
            String mainCategory = categories[0];

            String priceString = lineData[Data.PRICE];

            if(priceString.contains("BTC")) {
                priceString = priceString.replace("BTC", "");
                priceString = priceString.trim();

                try {
                    Float price = Float.valueOf(priceString);

                    context.write(new Text(mainCategory), new FloatWritable(price));

                } catch (NumberFormatException e) {
                    LOG.error(e.getMessage() + ": " + priceString);
                }
            }

        }
    }
}

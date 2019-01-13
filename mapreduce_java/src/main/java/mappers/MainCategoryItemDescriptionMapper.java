package mappers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import shared.Data;

import java.io.IOException;

public class MainCategoryItemDescriptionMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] lineData = line.split(Data.SEPARATOR);

        String[] categories = lineData[Data.CATEGORY].split("/");

        if(categories.length > 0) {
            context.write(new Text(categories[0]), new Text(lineData[Data.ITEM_DESCRIPTION]));
        }
    }
}

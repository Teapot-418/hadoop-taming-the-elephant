import runners.*;
import shared.Runner;

public class Entrypoint {

    private static final String EXEC_CATEGORY_COUNT = "category-count";
    private static final String EXEC_MAIN_CATEGORY_COUNT = "main-category-count";
    private static final String EXEC_AVG_ITEM_DESC_PER_CATEGORY = "average-item-description-length";
    private static final String EXEC_AVG_ITEM_NAME_PER_CATEGORY = "average-item-name-length";
    private static final String EXEC_AVG_ITEM_NAME_PER_MAIN_CATEGORY = "average-item-name-length-main";
    private static final String EXEC_AVG_ITEM_DESC_PER_MAIN_CATEGORY = "average-item-description-length-main";
    private static final String EXEC_AVG_PRICE_PER_MAIN_CATEGORY = "average-price-main";
    private static final String EXEC_MAX_PRICE_PER_MAIN_CATEGORY = "max-price-main";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: <execution-type> <input-path> <output-path>");
            System.exit(-1);
        }

        String executionType = args[0].toLowerCase();
        String inputPath = args[1];
        String outputPath = args[2];

        Runner runner = new CategoryCount();

        if (executionType.equals(EXEC_MAIN_CATEGORY_COUNT)) {
            runner = new MainCategoryCount();
        } else if (executionType.equals(EXEC_AVG_ITEM_DESC_PER_CATEGORY)) {
            runner = new AverageItemDescriptionLength();
        } else if (executionType.equals(EXEC_AVG_ITEM_NAME_PER_CATEGORY)) {
            runner = new AverageItemNameLength();
        } else if (executionType.equals(EXEC_AVG_ITEM_NAME_PER_MAIN_CATEGORY)) {
            runner = new MainCategoryAverageItemNameLength();
        } else if (executionType.equals(EXEC_AVG_ITEM_DESC_PER_MAIN_CATEGORY)) {
            runner = new MainCategoryAverageItemDescriptionLength();
        } else if (executionType.equals(EXEC_AVG_PRICE_PER_MAIN_CATEGORY)) {
            runner = new MainCategoryAveragePrice();
        } else if (executionType.equals(EXEC_MAX_PRICE_PER_MAIN_CATEGORY)) {
            runner = new MainCategoryMaxPrice();
        }

        runner.run(inputPath, outputPath);
    }
}

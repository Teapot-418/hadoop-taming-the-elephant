# darknetmapreduce-api2

Unfortunately the first version of darknetmapreduce was created with the older API of MapReduce. This MapReduce is based on API 2, which is the newer one since Hadoop 2.

> API 1 and API 2 are supported in parallel.

darknetmapreduce-api2 suppors several execution-types:

| parameter | explanation |
| --- | --- |
| category-count | List of detailed categories with quantity of entries|
| main-category-count | List of main categories with quantity of entries |
| average-item-description-length | List average length of item description per category |
| average-item-name-length | List average length of item name per category |
| average-item-name-length-main | List average lenth of item name per main-category |
| average-item-description-length-main | List average length of item description per main-category |
| average-price-main | List average price per main category |
| max-price-main | List maximum price per main category |

> If a wrong parameter is offered, the job will be executed as `category-count`. If no parameter is offered, the job breaks before execution.
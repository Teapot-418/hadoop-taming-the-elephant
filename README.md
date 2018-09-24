# Hadoop - Taming the Elephant (with a Whale)

This repository contains data for **Hadoop - Taming the Elephant (with a Whale)**.

## General Remarks

### Data-Set
The dataset is based on [Kaggle-Set](https://www.kaggle.com/philipjames11/dark-net-marketplace-drug-data-agora-20142015), the original dataset was a bit messed-up, therefore I removed some datasets. (I think, this is not such a big deal, due to the fact, that I am not going to do qualified research on that data, it is only planned to be a Hadoop introduction). More information on the base dataset can be found in the section "Remarks For The Data-Set".

Dataset columns: Vendor, Category, Item, Item Description, Price, Origin, Destination, Rating, Remarks

## Remarks For The Data-Set

### License
[CC0 1.0 Universal](https://creativecommons.org/publicdomain/zero/1.0/)

### Context
This data set was made from an html rip made by reddit user "usheep" who threatened to expose all the vendors on Agora to the police if they did not meet his demands (sending him a small monetary amount ~few hundred dollars in exchange for him not leaking their info). Most information about what happened to "usheep" and his threats is nonexistent. He posted the html rip and was never heard from again. Agora shut down a few months after. It is unknown if this was related to "usheep" or not, but the raw html data remained.
Content

This is a data parse of marketplace data ripped from Agora (a dark/deep web) marketplace from the years 2014 to 2015. It contains drugs, weapons, books, services, and more. Duplicate listings have been removed and prices have been averaged of any duplicates. All of the data is in a csv file and has over 100,000 unique listings.

### It is organized by:
Vendor: The seller
Category: Where in the marketplace the item falls under
Item: The title of the listing
Description: The description of the listing
Price: Cost of the item (averaged across any duplicate listings between 2014 and 2015)
Origin: Where the item is listed to have shipped from
Destination: Where the item is listed to be shipped to (blank means no information was provided, but mostly likely worldwide. I did not enter worldwide for any blanks however as to not make assumptions)
Rating: The rating of the seller (a rating of [0 deals] or anything else with "deals" in it means there is not concrete rating as the amount of deals is too small for a rating to be displayed)
Remarks: Only remark options are blank, or "Average price may be skewed outliar > .5 BTC found" which is pretty self explanatory.

### Acknowledgements
Though I got this data from a 3rd party, it seems as though it originally came from here: https://www.gwern.net/DNM-archives Gwern Branwen seems to have complied all of his dark net marketplace leaks and html rips and has a multitude of possible uses for the data at the link above. It is free for anyone to use as long as proper credit is given to the creator. I would be happy to parse more data if anyone would like to request a specific website and/or format.
Inspiration

This data could be used to track drug dealers across different platforms. Potentially find correlations between different drugs and from where/to they ship in the world to show correlations between types of drugs and where drug dealers that supply them are located. Prices can estimate drug economies in certain regions of the world. Similar listings from 2 different vendors can perhaps point to competition to corner a market, or even show that some vendors may work together to corner a market. There are quite a few opportunities to do some really great stuff to find correlations between illegal drugs, weapons, and more in order to curb the flow of dark net drug trade by identifying high risk regions or vendors. I can potentially do a new parse of other websites so you can find correlations across websites rather than just within Agora.
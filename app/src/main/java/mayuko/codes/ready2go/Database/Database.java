package mayuko.codes.ready2go.Database;

import mayuko.codes.ready2go.Models.Items;

public @interface Database {
    Class<Items> entities();

    int version();

    boolean exportSchema();
}

package vin.io.rest;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import vin.io.domain.WineBottle;

import javax.inject.Named;

@Component
@RestxResource
public class WineBottlesResource {

    private final JongoCollection bottles;

    public WineBottlesResource(@Named("bottles") JongoCollection bottles) {
        this.bottles = bottles;
    }

    @GET("/bottles")
    public Iterable<WineBottle> getAllBottles() {
        return bottles.get().find().as(WineBottle.class);
    }

    @POST("/bottles")
    public WineBottle createBottle(WineBottle bottle) {
        MongoCollection collection = bottles.get();
        bottle.setKey(new ObjectId().toString());
        collection.save(bottle);
        return bottle;
    }
}

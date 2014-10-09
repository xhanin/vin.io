package vin.io.rest;

import restx.annotations.GET;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import vin.io.domain.WineBottle;

import javax.inject.Named;

@Component
@RestxResource
public class WineBottleResource {

    private final JongoCollection bottles;

    public WineBottleResource(@Named("bottles") JongoCollection bottles) {
        this.bottles = bottles;
    }

    @GET("/bottles")
    public Iterable<WineBottle> getAllBottles() {
        return bottles.get().find().as(WineBottle.class);
    }
}

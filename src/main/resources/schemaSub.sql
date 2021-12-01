CREATE TABLE subscription (
    subscriber_uuid UUID NOT NULL,
    publisher_uuid UUID NOT NULL,
    subscription_date TIMESTAMP NOT NULL,
    PRIMARY KEY (subscriber_uuid, publisher_uuid),
    CONSTRAINT s_uuid
          FOREIGN KEY(subscriber_uuid)
    	  REFERENCES person(uuid),
    CONSTRAINT p_uuid
          FOREIGN KEY(publisher_uuid)
    	  REFERENCES person(uuid)
);
    
/**
 * 
 */
package com.thinkbiganalytics.metadata.rest.model.op;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.thinkbiganalytics.metadata.rest.model.Formatters;

/**
 *
 * @author Sean Felten
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dataset {

    public enum ChangeType {
        UPDATE, DELETE
    }
    
    public enum ContentType {
        PARTITIONS, FILES
    }

    private String time;
    private ChangeType changeType;
    private ContentType contentType;
    private List<ChangeSet> changeSets;
    
    public Dataset() {
        super();
    }
    
    public Dataset(DateTime time, ChangeType change, ContentType content, ChangeSet... changeSets) {
        super();
        this.time = Formatters.TIME_FORMATTER.print(time);
        this.changeType = change;
        this.contentType = content;
        this.changeSets = Arrays.asList(changeSets);
    }
    
    public Dataset(DateTime time, ChangeType change, ContentType content, List<ChangeSet> changeSets) {
        super();
        this.time = Formatters.TIME_FORMATTER.print(time);
        this.changeType = change;
        this.contentType = content;
        this.changeSets = changeSets;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    @JsonIgnore
    public void setTime(DateTime dateTime) {
        this.time = Formatters.TIME_FORMATTER.print(dateTime);
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType getType) {
        this.changeType = getType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public List<ChangeSet> getChangeSets() {
        return changeSets;
    }

    public void setChangeSets(List<ChangeSet> changeSets) {
        this.changeSets = changeSets;
    }

}

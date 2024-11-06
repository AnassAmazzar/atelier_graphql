package ma.emsi.inventoryservice.service.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

public class GraphQLExceptionHandler {
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env){
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return null;
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }
        };
    }
}

package edu.user.service.graphql.datafetchers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.user.repository.models.relationships.ApprovalApproveRelationshipEntity;
import edu.user.service.graphql.DataFetcherComponent;
import edu.user.service.graphql.UserServiceDataFetcher;
import edu.user.service.repository.ApproverApproveeRelationRepository;
import graphql.schema.DataFetchingEnvironment;

@DataFetcherComponent
public class ApproversDataFetcher implements UserServiceDataFetcher<List<ApprovalApproveRelationshipEntity>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApproversDataFetcher.class);

	@Autowired
	private ApproverApproveeRelationRepository approverApproveeRelationRepository;

	@Override
	public List<ApprovalApproveRelationshipEntity> get(DataFetchingEnvironment environment) throws Exception {
		LOGGER.info("************ ApproversDataFetcher thread name: {} ", Thread.currentThread().getName());
		Integer travelerTuid = environment.getArgument("travelerTuid");
		return approverApproveeRelationRepository.findByApprove(travelerTuid);
	}

	@Override
	public List<String> getTypeNames() {
		return Arrays.asList("approvers");
	}

}

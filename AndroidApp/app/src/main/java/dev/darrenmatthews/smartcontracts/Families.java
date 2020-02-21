package dev.darrenmatthews.smartcontracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.15.
 */
@SuppressWarnings("rawtypes")
public class Families extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061070d806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806309894c911461004657806363715d9d1461006a5780639f9cc6a314610092575b600080fd5b61004e610138565b604080516001600160a01b039092168252519081900360200190f35b6100906004803603602081101561008057600080fd5b50356001600160a01b0316610154565b005b610090600480360360208110156100a857600080fd5b8101906020810181356401000000008111156100c357600080fd5b8201836020820111156100d557600080fd5b803590602001918460018302840111640100000000831117156100f757600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506101eb945050505050565b336000908152602081905260409020546001600160a01b031690565b336000908152602081905260409020546001600160a01b031680156101bb576040805162461bcd60e51b8152602060048201526018602482015277416c72656164792070617274206f6620612066616d696c7960401b604482015290519081900360640190fd5b5033600090815260208190526040902080546001600160a01b0319166001600160a01b0392909216919091179055565b336000908152602081905260409020546001600160a01b03168015610252576040805162461bcd60e51b8152602060048201526018602482015277416c72656164792070617274206f6620612066616d696c7960401b604482015290519081900360640190fd5b600082336040516102629061032d565b6001600160a01b03821660208083019190915260408083528451908301528351829160608301919086019080838360005b838110156102ab578181015183820152602001610293565b50505050905090810190601f1680156102d85780820380516001836020036101000a031916815260200191505b509350505050604051809103906000f0801580156102fa573d6000803e3d6000fd5b5033600090815260208190526040902080546001600160a01b0319166001600160a01b0392909216919091179055505050565b61039d8061033b8339019056fe6080604052600560015534801561001557600080fd5b5060405161039d38038061039d8339818101604052604081101561003857600080fd5b810190808051604051939291908464010000000082111561005857600080fd5b90830190602082018581111561006d57600080fd5b825164010000000081118282018810171561008757600080fd5b82525081516020918201929091019080838360005b838110156100b457818101518382015260200161009c565b50505050905090810190601f1680156100e15780820380516001836020036101000a031916815260200191505b5060405260209081015184519093506101009250600091850190610157565b50600280546001810182556000919091527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace0180546001600160a01b0319166001600160a01b0392909216919091179055506101f2565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061019857805160ff19168380011785556101c5565b828001600101855582156101c5579182015b828111156101c55782518255916020019190600101906101aa565b506101d19291506101d5565b5090565b6101ef91905b808211156101d157600081556001016101db565b90565b61019c806102016000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806311aee3801461003b578063d26e329b14610055575b600080fd5b6100436100d2565b60408051918252519081900360200190f35b61005d6100d8565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561009757818101518382015260200161007f565b50505050905090810190601f1680156100c45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60015481565b6000805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561015e5780601f106101335761010080835404028352916020019161015e565b820191906000526020600020905b81548152906001019060200180831161014157829003601f168201915b50505050508156fea26469706673582212202647c6fc2ef3107a257898700643743fc4723c035ed4bf64bb721be95d8b1c4464736f6c63430006030033a2646970667358221220c98e47f6acbd549b18ec168ca4200597ecd26cd372d308c43010ab0deedf569564736f6c63430006030033";

    public static final String FUNC_CREATEFAMILY = "createFamily";

    public static final String FUNC_JOINFAMILY = "joinFamily";

    public static final String FUNC_MYFAMILY = "myFamily";

    public static final Event PRINT_EVENT = new Event("print", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}));
    ;

    @Deprecated
    protected Families(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Families(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Families(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Families(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<PrintEventResponse> getPrintEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PRINT_EVENT, transactionReceipt);
        ArrayList<PrintEventResponse> responses = new ArrayList<PrintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PrintEventResponse typedResponse = new PrintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PrintEventResponse> printEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PrintEventResponse>() {
            @Override
            public PrintEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRINT_EVENT, log);
                PrintEventResponse typedResponse = new PrintEventResponse();
                typedResponse.log = log;
                typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PrintEventResponse> printEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRINT_EVENT));
        return printEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createFamily(String _name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATEFAMILY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> joinFamily(String _toJoin) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_JOINFAMILY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _toJoin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> myFamily() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MYFAMILY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Families load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Families(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Families load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Families(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Families load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Families(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Families load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Families(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Families> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Families.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Families> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Families.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Families> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Families.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Families> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Families.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class PrintEventResponse extends BaseEventResponse {
        public byte[] name;
    }
}

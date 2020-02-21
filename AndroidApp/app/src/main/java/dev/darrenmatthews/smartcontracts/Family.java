package dev.darrenmatthews.smartcontracts;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class Family extends Contract {
    public static final String BINARY = "6080604052600560015534801561001557600080fd5b5060405161039d38038061039d8339818101604052604081101561003857600080fd5b810190808051604051939291908464010000000082111561005857600080fd5b90830190602082018581111561006d57600080fd5b825164010000000081118282018810171561008757600080fd5b82525081516020918201929091019080838360005b838110156100b457818101518382015260200161009c565b50505050905090810190601f1680156100e15780820380516001836020036101000a031916815260200191505b5060405260209081015184519093506101009250600091850190610157565b50600280546001810182556000919091527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace0180546001600160a01b0319166001600160a01b0392909216919091179055506101f2565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061019857805160ff19168380011785556101c5565b828001600101855582156101c5579182015b828111156101c55782518255916020019190600101906101aa565b506101d19291506101d5565b5090565b6101ef91905b808211156101d157600081556001016101db565b90565b61019c806102016000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806311aee3801461003b578063d26e329b14610055575b600080fd5b6100436100d2565b60408051918252519081900360200190f35b61005d6100d8565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561009757818101518382015260200161007f565b50505050905090810190601f1680156100c45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60015481565b6000805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561015e5780601f106101335761010080835404028352916020019161015e565b820191906000526020600020905b81548152906001019060200180831161014157829003601f168201915b50505050508156fea26469706673582212202647c6fc2ef3107a257898700643743fc4723c035ed4bf64bb721be95d8b1c4464736f6c63430006030033";

    public static final String FUNC_FAMILYNAME = "familyName";

    public static final String FUNC_MEMBERCOUNT = "memberCount";

    @Deprecated
    protected Family(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Family(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Family(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Family(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> familyName() {
        final Function function = new Function(FUNC_FAMILYNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> memberCount() {
        final Function function = new Function(FUNC_MEMBERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Family load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Family(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Family load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Family(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Family load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Family(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Family load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Family(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Family> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _name, String _creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Address(160, _creator)));
        return deployRemoteCall(Family.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Family> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _name, String _creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Address(160, _creator)));
        return deployRemoteCall(Family.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Family> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, String _creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Address(160, _creator)));
        return deployRemoteCall(Family.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Family> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, String _creator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Address(160, _creator)));
        return deployRemoteCall(Family.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}

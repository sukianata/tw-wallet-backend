package com.thoughtworks.wallet.asset.service.impl;

import com.thoughtworks.common.annotation.QuorumRPCUrl;
import com.thoughtworks.common.exception.*;
import com.thoughtworks.common.util.JacksonUtil;
import com.thoughtworks.wallet.asset.annotation.IdentitiesContractAddress;
import com.thoughtworks.wallet.asset.request.DCEPMintRequest;
import com.thoughtworks.wallet.asset.response.*;
import com.thoughtworks.wallet.asset.service.IDCEPService;
import com.thoughtworks.wallet.wrapper.DCEPContract;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class DCEPServiceImpl implements IDCEPService {

    private static final String RMB_CONTRACT_PATH = "/contracts/RMB.json";
    private final Web3j web3j;
    private final DCEPContract decp;
    private final ModelMapper modelMapper = new ModelMapper();
    private final JacksonUtil jacksonUtil;

    // TODO：做成可以自动切换节点，有重试机制的请求模块。这里只是为了打印错误好调试
    @QuorumRPCUrl
    private String rpcUrl;

    @IdentitiesContractAddress
    private String identityRegistryContractAddress;

    @Autowired
    public DCEPServiceImpl(Web3j web3j, DCEPContract decp, JacksonUtil jacksonUtil) {
        this.web3j = web3j;
        this.decp = decp;
        this.jacksonUtil = jacksonUtil;
    }



    @Override
    public DCEPNFTInfoV2Response getDCEPInfo(String id) {
        return null;
    }

    @Override
    public DCEPNFTInfoV2Response mint(DCEPMintRequest mintRequest) {

        log.info("mint - DCEPMintRequest: {}", mintRequest.toString());
        try {
            // 拿到生成money的序号
            int index = 1;

            // 根据请求的money生成冠字号
//            https://ethereum.stackexchange.com/questions/23549/convert-string-to-bytes32-in-web3j/
    //           List<BigInteger> moneys = mintRequest.getMoneys().stream().map((money)->{
    //               String name = String.format("CB_%d_%d", money.longValue(), index);
    //
    //           });

            // 批量生产 NFT
            this.decp.mintBatch(mintRequest.getAddress(), mintRequest.getMoneys()).sendAsync();

            // 创建银行签名

            // 把信息保存到数据库

            // 返回给客户端

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new TransferException(rpcUrl);
        }
        return null;
    }

    @Override
    public DCEPInfoV2Response getDCEPInfo() {
        final String decpSymbol = "￥";
        final String decpName = "DC/EP";
        final BigInteger decpDecimal = new BigInteger("2");


        final String decpContractPath = "/contracts/RMB.json";
        final String jsonString;
        String abi;
        try {
            jsonString = jacksonUtil.readJsonFile(decpContractPath);
            abi = jacksonUtil.parsePropertyFromJson(jsonString, "abi");
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ReadFileErrorException(decpContractPath);
        }

        return DCEPInfoV2Response.of(decp.getContractAddress(), decpName, decpSymbol, decpDecimal, abi);
    }
}

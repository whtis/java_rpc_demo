package service;

import com.red_packet.rpc.RedPacketService;
import com.red_packet.rpc.SendRpReq;
import com.red_packet.rpc.SendRpResp;
import org.apache.thrift.TException;

public class RedPacketServiceImpl implements RedPacketService.Iface {
    @Override
    public SendRpResp SendRp(SendRpReq req) throws TException {
        System.out.println("server: rpc req income:" + req);
        SendRpResp resp = new SendRpResp();
        resp.errCode = 0;
        resp.errMsg = "success";
        resp.rpId = "testrpid001111";
        return resp;
    }
}

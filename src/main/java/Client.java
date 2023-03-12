import com.red_packet.rpc.RedPacketService;
import com.red_packet.rpc.SendRpReq;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;


public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 19091;//Thrift server listening port
    private static final int TIMEOUT = 3000;

    private void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            RedPacketService.Client client = new RedPacketService.Client(protocol);
            transport.open();

            SendRpReq req = new SendRpReq();
            req.setUserId("javaUserId");
            req.setGroupId("javaGroupId");
            req.setAmount(2000);
            req.setNumber(10);
            req.setBizOutNo("javaBizOutNo001");
            System.out.println("client: rpc response from server:" + userName + "," + client.SendRp(req));
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startClient("redPacket");
    }

}

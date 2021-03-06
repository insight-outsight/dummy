package javalanguage.data_compression;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;


public final class JDKDeflateUtils {

    /**
     * 压缩
     *
     * @param data 待压缩数据
     * @return byte[] 压缩后的数据
     */
    public static byte[] compress(byte[] data) {
        byte[] output = new byte[0];

        Deflater compresser = new Deflater();

        compresser.reset();
//        compresser.setLevel(9);
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        compresser.end();
        return output;
    }

    /**
     * 解压缩
     *
     * @param data 待压缩的数据
     * @return byte[] 解压缩后的数据
     */
    public static byte[] decompress(byte[] data) {
        byte[] output = new byte[0];

        Inflater decompresser = new Inflater();
        decompresser.reset();
        decompresser.setInput(data);

        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        decompresser.end();
        return output;
    }

    public static void main(String[] args) throws IOException {
//        String inputStr = "snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zl";
//        String inputStr = "节点「0」,待发:608631 ,已发:608631 ,结果：Success. "+
//							"节点「1」,待发:606786 ,已发:606786 ,结果：Success. "+
//							"节点「2」,待发:607410 ,已发:607410 ,结果：Success. "+
//							"节点「3」,待发:606628 ,已发:606628 ,结果：Success. "+
//							"节点「4」,待发:605552 ,已发:605552 ,结果：Success. "+
//							"节点「5」,待发:604472 ,已发:604472 ,结果：Success. "+
//							"节点「6」,待发:605894 ,已发:605894 ,结果：Success. "+
//							"节点「7」,待发:605903 ,已发:605903 ,结果：Success. "+
//							"节点「8」,待发:607277 ,已发:607277 ,结果：Success. "+
//							"节点「9」,待发:605004 ,已发:605004 ,结果：Success. ";
//    	String inputStr = "ewrwr,\"我\":\"去\"wer368有的和，a";

//        String inputStr = "{\"_\":\"msg\",\"to\":\"1158336\",\"type\":11,\"contents\":[{\"text\":\"Gf【英雄联盟吧】一点寒芒先到，随后抢出如龙！\",\"s\":\"48x48\",\"goto\":\"[|goto_tieba_tie|17517377]\",\"lt\":1,\"pic\":\"http://img.momocdn.com/album/2E/0C/2E0C7090-A398-41FC-3505-BB6F7BAAA8BC_S.jpg\"},{\"text\":\"【英雄联盟吧】有没有一个英雄你第一次玩的时候就狠叼\",\"s\":\"48x48\",\"goto\":\"[|goto_tieba_tie|17432046]\",\"lt\":0,\"pic\":\"http://img.momocdn.com/album/2E/0C/2E0C7090-A398-41FC-3505-BB6F7BAAA8BC_S.jpg\"},{\"goto\":”[查看详情|goto_tieba_tie|17178740]\",\"lt”:2}],\"text\":\"陌陌吧精华推荐\",\"id\":\"wetrhyrtyty6\"}";
//        String inputStr = "{\"source\":\"10.83.212.102\",\"id\":\"\",\"params\":{\"to\":\"182202500\",\"bk_from_location\":{\"time\":1499658523000,\"slat\":0.0,\"slng\":0.0,\"locType\":0,\"lat\":39.938293,\"lng\":116.454409,\"acc\":0.0,\"ip\":null,\"deviation\":0},\"sex\":\"F\",\"imjpacket\":{\"fields\":{\"dt\":0,\"noreply\":1,\"id\":\"1ecd125d\",\"to\":\"182202500\",\"distance\":-2.0,\"username\":\"小明\",\"text\":\"你好啊,通过分析基本可以断定流量产生来自于app服务器对redis服务器数据调用,至于为什么为产生大流量,需要进一步分析,redis的monitor命令可以实时打印出 redi...Redis中文网首页 Redis教程 Redis命令 Redis客户端 Redis下载 Rds数据库 ...Redis 服务器Redis Monitor 命令用于实时打印出 Redis 服务器接收到的命令,调试...\",\"t\":1499658764916,\"fr\":\"210406642\",\"_\":\"msg\",\"type\":1,\"real_distance\":892.8},\"id\":\"1ecd125d\",\"action\":\"msg\"},\"timemsec\":1499658764916,\"sr\":\"\",\"notToSelfWeb\":false,\"from\":\"210406642\",\"sourceHostport\":\"10.83.65.60:6341\",\"regtime\":1411186736,\"ignoreReply\":false,\"user_data_ex_map\":{\"ex_relation\":\"None\",\"ex_isnoreply\":\"true\",\"ex_from_photos_num\":\"7\"},\"msgSource\":0,\"isNotice\":false,\"ignoreSpam\":false},\"action\":\"general_msg\",\"thread\":\"\"}";
//        String inputStr = "{\"params\":{\"to\":\"182460550\",\"ignoreReply\":false,\"bakPacket\":{\"fields\":{\"id\":\"QF_mass_1499420705_2273_11_182460550\",\"to\":\"182460550\",\"text\":\"7月9日，从陕西宝鸡到甘肃兰州的宝兰高铁将正式通车运营。宝兰高铁的通车打通了中国高铁横贯东西的“最后一公里”\",\"t\":1499486609999,\"contents\":[{\"text\":\"哈喽啊\",\"s\":\"200x120\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70884654|massclickstat_mass_1499420705_2273_11_0]\",\"pic\":\"http://img.momocdn.com/app/2D/D0/2DD0A333-FDF9-B1DB-A53E-0C5BDEAD0FD820170707.jpg\",\"lt\":1},{\"text\":\"宝兰高铁与已开通运营的徐兰高铁西宝段、兰新高铁连通，将中国西北地区全面融入全国高速铁路网。\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70567618|massclickstat_mass_1499420705_2273_11_1]\",\"pic\":\"http://img.momocdn.com/app/CC/BA/CCBA3753-27CB-9D20-1298-BBFA48713C9620170707.png\",\"lt\":0},{\"text\":\"旅客们纷纷拿出手机拍照，纪念自己乘坐该次高铁。\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70889706|massclickstat_mass_1499420705_2273_11_2]\",\"pic\":\"http://img.momocdn.com/app/D3/C2/D3C2BB90-20B8-01E6-27D5-F6EDAA33F4D820170707.png\",\"lt\":0},{\"text\":\"视觉中国\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70948011|massclickstat_mass_1499420705_2273_11_3]\",\"pic\":\"http://img.momocdn.com/app/71/FB/71FBF35C-9889-0720-7871-DCC25A67EF0320170707.png\",\"lt\":0}],\"fr\":\"10010\",\"_\":\"msg\",\"type\":8,\"foldV2\":1,\"fold\":1},\"id\":\"QF_mass_1499420705_2273_11_182460550\",\"action\":\"msg\"},\"imjpacket\":{\"fields\":{\"dt\":0,\"id\":\"QF_mass_1499420705_2273_11_182460550\",\"to\":\"182460550\",\"distance\":-2.0,\"text\":\"陕西西安，西安铁路局西安动车段存车场，首趟宝兰高铁动车组列车——西安北至兰州西D2651次即将始发。宝兰高铁高铁线路全长401公里，自陕西省宝鸡市引出后\",\"t\":1499486609999,\"contents\":[{\"text\":\"经甘肃省的天水市、秦安县、通渭县、定西市至兰州市，全线设宝鸡南、天水南、秦安、通渭、定西北、兰州西等8个车站，运营时速250公里\",\"s\":\"200x120\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70884654|massclickstat_mass_1499420705_2273_11_0]\",\"pic\":\"http://img.momocdn.com/app/2D/D0/2DD0A333-FDF9-B1DB-A53E-0C5BDEAD0FD820170707.jpg\",\"lt\":1},{\"text\":\"票价本土化asdfghjkl\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70567618|massclickstat_mass_1499420705_2273_11_1]\",\"pic\":\"http://img.momocdn.com/app/CC/BA/CCBA3753-27CB-9D20-1298-BBFA48713C9620170707.png\",\"lt\":0},{\"text\":\"wq\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70889706|massclickstat_mass_1499420705_2273_11_2]\",\"pic\":\"http://img.momocdn.com/app/D3/C2/D3C2BB90-20B8-01E6-27D5-F6EDAA33F4D820170707.png\",\"lt\":0},{\"text\":\"民警在首发仪式现场巡视，确保首发列车安全\",\"s\":\"48x48\",\"goto\":\"[|url|https://passport.immomo.com/authorize?redirect_uri=https%3A%2F%2Fm.immomo.com%2Fs%2Flive%2Fcircle%2Findex.html%3F_bid%3D1229%26pid%3DA70948011|massclickstat_mass_1499420705_2273_11_3]\",\"pic\":\"http://img.momocdn.com/app/71/FB/71FBF35C-9889-0720-7871-DCC25A67EF0320170707.png\",\"lt\":0}],\"fr\":\"10010\",\"_\":\"msg\",\"type\":11,\"foldV2\":1,\"fold\":1},\"id\":\"QF_mass_1499420705_2273_11_182460550\",\"action\":\"msg\"},\"push_text\":\"民警在首发仪式现场巡视，确保首发列车安全\",\"timemsec\":1499486609999,\"isNotice\":false,\"msgSource\":0,\"notToSelfWeb\":false,\"from\":\"10010\",\"clientVersion\":{\"wp\":0,\"iOS\":401,\"eios\":0,\"Android\":510},\"ignoreSpam\":false},\"id\":\"\",\"action\":\"proxy_msg\",\"source\":\"10.83.68.149\",\"thread\":\"\"}";
//        String inputStr = "e中3.修改redis节一个 web 可视化，性能优化的 redis 监控程序，使用 flask + sqlite 完成，使用简单，部署方便";
//        String inputStr = "{\"source\":\"10.83.220.118\",\"id\":\"\",\"params\":{\"to\":\"187321280\",\"ignoreReply\":false,\"imjpacket\":{\"fields\":{\"id\":\"4de7cac5-6cab-4d\",\"to\":\"187321280\",\"msgid\":[\"1a5428ef\"],\"t\":1499658764340,\"fr\":\"291226937\",\"_\":\"msgst\",\"st\":\"read\"},\"id\":\"4de7cac5-6cab-4d\",\"action\":\"msgst\"},\"timemsec\":1499658764340,\"isNotice\":false,\"msgSource\":0,\"notToSelfWeb\":false,\"from\":\"291226937\",\"ignoreSpam\":false},\"thread\":\"\",\"action\":\"msgst\"}";
        String inputStr = "{\"params\":{\"sendtoall\":false,\"isSave\":true,\"to\":\"33732080\",\"distance\":{\"293502299\":5145.0,\"127239750\":2949.0,\"481391943\":5428.0,\"336233666\":27247.0,\"510795690\":2830.0,\"468299374\":30611.0,\"109410107\":379572.0,\"505770817\":5676.0,\"390000197\":5502.0,\"158068482\":5538.0,\"126714547\":7720.0,\"91972117\":1077112.0,\"117058752\":4223.0,\"148149817\":195197.0,\"370433694\":1585.0,\"343910340\":51047.0,\"485355568\":1391170.0,\"464269449\":3906.0,\"153619067\":1810.0,\"341492489\":12391.0,\"184434933\":2754.0,\"367235343\":16177.0,\"67099265\":22946.0,\"393067914\":150248.0,\"310637636\":1343.0,\"137034916\":1.1894557E7,\"166141312\":6505.0,\"427237437\":4725.0,\"320870498\":21148.0,\"283092239\":5574.0,\"249256990\":32403.0,\"334949800\":8941.0,\"457625902\":17256.0,\"249347637\":4013.0,\"dt\":1499681328000,\"47221509\":6971.0,\"361209028\":3822.0,\"201332183\":901.0,\"168907221\":10773.0,\"461262900\":23765.0,\"393552509\":356984.0,\"417019085\":3619.0,\"351942303\":1692.0,\"490664189\":7776.0,\"256795329\":5841.0,\"37338869\":18391.0,\"305952741\":7645.0,\"189775577\":4864.0,\"107683669\":1553973.0,\"475458575\":4428.0,\"286537156\":4472.0,\"477440356\":3080.0,\"491540746\":225021.0,\"480992451\":1512.0,\"336819354\":4615.0,\"485731855\":3820.0,\"355833141\":1078977.0,\"430480290\":5262.0,\"183878925\":4195.0,\"401670226\":5826.0,\"470464871\":1785643.0,\"460071865\":8299.0,\"409098776\":12535.0,\"346732195\":10939.0,\"341914968\":7454.0,\"42912396\":4178.0,\"242977359\":479.0,\"229085427\":13425.0,\"47265014\":3307.0,\"235059924\":1587.0,\"338527294\":6926.0,\"448093841\":1418.0,\"64339552\":10948.0,\"55919203\":81.0,\"212636247\":908376.0,\"369883873\":5823.0,\"407498198\":1244.0,\"418324557\":3544.0,\"431478386\":7282.0,\"317320219\":4102.0,\"140387312\":23536.0,\"98875878\":34223.0,\"326520473\":4644.0,\"380175086\":1221310.0,\"397957963\":2163.0,\"84389066\":5098.0,\"464127933\":17027.0,\"50545027\":4306.0,\"402301784\":1772.0,\"464287237\":1931.0,\"147836508\":18855.0,\"211292951\":29176.0,\"29781075\":609376.0,\"30735608\":8000.0,\"296485702\":23643.0,\"142336924\":2841.0,\"180529916\":7580.0,\"458226035\":1884.0,\"479572935\":2031.0,\"177986311\":18927.0,\"428123098\":5233.0,\"469432938\":16080.0,\"455718444\":8373.0,\"417006964\":2707.0,\"387716191\":12472.0,\"467419420\":372430.0,\"382797910\":5015.0,\"53952232\":110281.0,\"232599412\":6427.0,\"453545855\":38660.0,\"53706983\":11138.0,\"496139456\":2669.0,\"359673516\":5637.0,\"118680389\":22430.0,\"354970442\":10533.0,\"460573556\":7563.0,\"76017001\":30649.0,\"321392127\":6847.0,\"401576994\":7018.0,\"141548085\":18519.0,\"238878438\":4178.0,\"58970433\":6460.0,\"173842837\":1831251.0,\"492505471\":7197.0,\"478788688\":4108.0,\"485037281\":9410.0,\"146902669\":2774.0,\"462110005\":5866.0,\"128204367\":16191.0,\"376706784\":30263.0,\"466212431\":8323.0,\"123895612\":4046.0,\"103426939\":27221.0,\"398010003\":5546.0,\"46543980\":11154.0,\"110949521\":3588.0,\"476762966\":5246.0,\"377046168\":5345.0,\"459699079\":126038.0,\"114933615\":2817.0,\"510563384\":5604.0,\"157099367\":11687.0,\"459919384\":350910.0,\"131848217\":11377.0,\"430308554\":2371.0,\"125853130\":4211.0,\"36516239\":931.0,\"302520664\":4745.0,\"409160427\":7222.0,\"471347615\":6058.0,\"224260019\":4403.0,\"72066146\":7084.0,\"476191289\":14448.0,\"315404044\":7788.0,\"344036872\":2849.0,\"44171677\":18995.0,\"449734587\":5673.0,\"10536716\":2846.0,\"470024272\":87166.0,\"373452756\":5750.0,\"497604239\":6302.0,\"356409394\":18755.0,\"459954035\":3204.0,\"152002873\":14468.0,\"284570953\":1415.0,\"306666590\":8608.0,\"378830063\":30241.0,\"364461729\":4290.0,\"450362036\":7996.0,\"283148551\":946012.0,\"159516729\":26295.0,\"236376286\":9171.0,\"343998352\":11226.0,\"103946371\":9728.0,\"425441077\":6650.0,\"374521913\":309428.0,\"451211456\":63952.0,\"312379916\":1762.0,\"352753718\":183.0,\"97897146\":599.0,\"326863168\":8419.0,\"262140042\":3432.0,\"125976583\":432045.0,\"365235881\":66425.0,\"501173361\":6544.0,\"404998572\":386.0,\"103145213\":481492.0,\"406039007\":6342.0,\"337519235\":5135.0,\"248895049\":5305.0,\"333755419\":13966.0,\"33621596\":376043.0,\"216837117\":2829.0,\"307075637\":338697.0,\"288165894\":6401.0,\"98252372\":1040606.0,\"459145260\":1725.0,\"30865470\":3754.0,\"406914741\":8464.0,\"65258500\":18471.0,\"143333167\":21382.0,\"405162892\":2106.0,\"87831455\":863718.0,\"152583871\":1650.0,\"132874671\":1638.0,\"454234967\":368.0,\"268084306\":18152.0,\"346996516\":25049.0,\"463390554\":3839.0,\"434554615\":8332.0,\"454149173\":29359.0,\"305448449\":681039.0,\"484657246\":5106.0,\"325854558\":12217.0,\"453567458\":4813.0,\"52633879\":9165.0,\"430609830\":1267.0,\"399530290\":11736.0,\"457766437\":7687.0,\"437994853\":54835.0,\"445686201\":3489.0,\"457760189\":398137.0,\"417839230\":4768.0,\"499112734\":6229.0,\"189428202\":1361.0,\"364687881\":4046.0,\"201816184\":26002.0,\"230694311\":5813.0,\"459056241\":8352.0,\"413113407\":5364.0,\"300632182\":10106.0,\"252648922\":6916.0,\"132298533\":2791.0,\"454766712\":34170.0,\"337156619\":7798.0,\"455901822\":2236.0,\"72927156\":10095.0,\"498265777\":616.0,\"432282466\":5297.0,\"150819721\":6996.0,\"85931276\":22285.0,\"330914319\":11996.0,\"121467200\":25777.0,\"33306771\":4225.0,\"289477587\":23570.0,\"459168407\":12765.0,\"306105695\":824507.0,\"492581384\":1968.0,\"286201700\":72175.0,\"297065985\":18234.0,\"230216196\":2789.0,\"364928685\":1894.0,\"459311006\":0.0,\"126111298\":2005.0,\"352031838\":4688.0,\"371275392\":2847.0,\"51783938\":1677.0,\"509651985\":21458.0,\"248139798\":1393684.0},\"imjpacket\":{\"fields\":{\"id\":\"51924098\",\"to\":\"33732080\",\"text\":\"一起来吧\",\"t\":1499682374129,\"fr\":\"459311006\",\"_\":\"gmsg\",\"ut\":\"雪碧\",\"type\":1,\"bs\":1},\"id\":\"51924098\",\"action\":\"gmsg\"},\"isNotice\":false,\"from\":\"459311006\",\"ignoreSpam\":false},\"source\":\"10.83.220.118\",\"id\":\"\",\"action\":\"imj_gmsg\",\"thread\":\"\"}";
//        String inputStr = "{\"params\":{\"sendtoall\":false,\"isSave\":true,\"to\":\"34475740\",\"distance\":{\"495063171\":-2.0,\"418914374\":-2.0,\"446256469\":-2.0,\"133372136\":431690.0,\"391833792\":1147912.0,\"50890423\":428489.0,\"367832857\":-2.0,\"376545213\":-2.0,\"451687177\":-2.0,\"429522749\":-2.0,\"360357516\":-2.0,\"401131184\":85698.0,\"513106254\":-2.0,\"494970359\":-2.0,\"344753891\":-2.0,\"161708480\":432514.0,\"512162064\":-2.0,\"427581704\":-2.0,\"210527460\":-2.0,\"240947388\":-2.0,\"98711219\":-2.0,\"32685366\":-2.0,\"502064221\":-2.0,\"498382493\":-2.0,\"303177171\":-2.0,\"247732025\":435487.0,\"510619745\":-2.0,\"474852903\":-2.0,\"439508510\":-2.0,\"482646164\":-2.0,\"251393348\":-2.0,\"486611713\":-2.0,\"294696576\":-2.0,\"252189010\":428750.0,\"325456452\":-2.0,\"187483754\":-2.0,\"221786074\":-2.0,\"457366794\":-2.0,\"337343047\":-2.0,\"dt\":1499623348000,\"246445853\":435423.0,\"251519796\":-2.0,\"121839317\":-2.0,\"93585326\":428600.0,\"355569551\":-2.0,\"487993956\":-2.0,\"447380562\":-2.0,\"268287133\":-2.0,\"486482360\":-2.0,\"245993394\":428598.0,\"157188475\":-2.0,\"514521398\":-2.0,\"398270414\":-2.0,\"505637912\":-2.0,\"298411425\":-2.0,\"491302671\":-2.0,\"213236118\":-2.0,\"493154998\":-2.0,\"467828643\":-2.0,\"492114294\":-2.0,\"283009663\":-2.0,\"465918536\":-2.0,\"182930577\":-2.0,\"501420809\":429172.0,\"497773259\":-2.0,\"454725259\":-2.0,\"506762458\":-2.0,\"287589920\":-2.0,\"503158544\":-2.0,\"71239966\":-2.0,\"484851104\":-2.0,\"512691446\":-2.0,\"396429293\":76891.0,\"413272648\":-2.0,\"367660281\":-2.0,\"136604378\":-2.0,\"108315050\":-2.0,\"242228351\":428572.0,\"130897607\":-2.0,\"442426837\":-2.0,\"453917797\":-2.0,\"381629640\":-2.0,\"154954128\":319995.0,\"406808138\":-2.0,\"429242911\":-2.0,\"466659825\":-2.0,\"55010301\":-2.0,\"448285567\":-2.0,\"455241483\":-2.0,\"269902837\":-2.0,\"406552342\":-2.0,\"507176559\":-2.0,\"313918575\":-2.0},\"imjpacket\":{\"fields\":{\"id\":\"95531842\",\"to\":\"34475740\",\"text\":\"[|et|l=custom|n=AEB806CC-E74C-D616-E606-6E514F54DBF220160619.gif|s=280x356|goto=]\",\"t\":1499682374509,\"fr\":\"136604378\",\"_\":\"gmsg\",\"ut\":\"受不了后\",\"type\":5,\"bs\":1},\"id\":\"95531842\",\"action\":\"gmsg\"},\"isNotice\":false,\"from\":\"136604378\",\"ignoreSpam\":false},\"source\":\"10.83.202.93\",\"id\":\"\",\"action\":\"imj_gmsg\",\"thread\":\"\"}";
//        String inputStr = "{\"params\":{\"sendtoall\":false,\"isSave\":true,\"to\":\"33475500\",\"distance\":{\"142896664\":20865.0,\"457587949\":36719.0,\"432791182\":100969.0,\"212294941\":14981.0,\"141993806\":8767.0,\"442458687\":15815.0,\"316692564\":13748.0,\"180077623\":112152.0,\"66023008\":12419.0,\"318673959\":153290.0,\"202932621\":0.0,\"212666271\":6302.0,\"162159004\":16234.0,\"431593891\":11538.0,\"300612239\":14832.0,\"459023044\":157912.0,\"230041671\":9649.0,\"504806888\":10454.0,\"435923533\":16398.0,\"82791324\":191542.0,\"108274736\":9494.0,\"377711231\":14884.0,\"85234076\":9432.0,\"425516382\":9664.0,\"465562609\":464393.0,\"510684181\":152087.0,\"360826850\":14545.0,\"456277465\":96613.0,\"347555833\":2924547.0,\"dt\":1499683747000,\"478313722\":10672.0,\"137235808\":13170.0,\"262016903\":31760.0,\"343198832\":11235.0,\"189614397\":156726.0,\"441157157\":332720.0,\"403880543\":11135.0,\"434746302\":16503.0,\"446617317\":12202.0,\"471248565\":98547.0,\"382369426\":21567.0,\"490329706\":29501.0,\"402203972\":227660.0,\"409677918\":14016.0,\"447304758\":249491.0,\"389830084\":1725356.0,\"217918164\":13111.0,\"462053313\":822608.0,\"483601046\":18985.0,\"245440533\":11670.0,\"327200868\":10990.0,\"189952081\":15543.0,\"92381925\":10158.0,\"274163619\":8795.0,\"505855016\":284429.0,\"434571872\":11363.0,\"404926982\":14916.0,\"216764013\":12680.0,\"508734052\":783281.0,\"389496375\":284810.0},\"imjpacket\":{\"fields\":{\"id\":\"fe2fde79\",\"to\":\"33475500\",\"text\":\"@还隔墙有耳也不能辽宁附近受不了受制于人[南无棒球]\",\"t\":1499684064220,\"at\":[\"409677918\"],\"fr\":\"202932621\",\"_\":\"gmsg\",\"ut\":\"天各一方\",\"attext\":\"[不南本来]\",\"type\":1,\"bs\":1},\"id\":\"fe2fde79\",\"action\":\"gmsg\"},\"isNotice\":false,\"from\":\"202932621\",\"ignoreSpam\":false},\"source\":\"10.83.220.118\",\"id\":\"\",\"action\":\"imj_gmsg\",\"thread\":\"\"}";
        System.out.println(System.getProperty("file.encoding"));
//    	System.out.println("1="+inputStr.getBytes().length);
//    	String o = new String(inputStr.getBytes());
//    	System.out.println("1="+o);
//    	System.out.println("1="+o.equals(inputStr));
////    	
//    	System.out.println("2="+inputStr.getBytes("ISO-8859-1").length);
//    	o = new String(inputStr.getBytes("ISO-8859-1"),"ISO-8859-1");
//    	System.out.println("2="+o);
//    	System.out.println("2="+o.equals(inputStr));
//    	
//    	System.out.println("3="+inputStr.getBytes("UTF-8").length);
//    	o = new String(inputStr.getBytes("UTF-8"));
//    	System.out.println("3="+o);
//    	System.out.println("3="+o.equals(inputStr));
//    	
//    	System.out.println("4="+inputStr.getBytes("GBK").length);
//    	o = new String(inputStr.getBytes("GBK"),"GBK");
//    	System.out.println("4="+o);
//    	System.out.println("4="+o.equals(inputStr));
    	
        System.out.println("输入字符串:\t" + inputStr);
        byte[] input = inputStr.getBytes();
        System.out.println("输入字节长度:\t" + input.length);
        long t = System.currentTimeMillis();
        byte[] output = JDKDeflateUtils.compress(input);
        System.out.println("压缩后字节长度:\t" + output.length+"  ,cost:"+(System.currentTimeMillis()-t));
        t = System.currentTimeMillis();
        String tempStorageStr = new String(output,"ISO-8859-1");
        System.out.println("tempStorageStr:\t" + tempStorageStr);
        System.out.println("tempStorageStr长度:\t" + tempStorageStr.length()+"  ,cost:"+(System.currentTimeMillis()-t));
        byte[] tempStorageStrByte = tempStorageStr.getBytes("UTF-8");
        System.out.println("tempStorageStrByte长度:\t" + tempStorageStrByte.length);
        t = System.currentTimeMillis();
        String tempStorageStrRev = new String(tempStorageStrByte,"UTF-8");
        System.out.println("------------------------------------diaobaole12------------------------------------");
        System.out.println("tempStorageStrRev:\t" + tempStorageStrRev);
        System.out.println("tempStorageStrRev字节长度:\t" + tempStorageStrRev.length()+"  ,cost:"+(System.currentTimeMillis()-t));
        System.out.println(tempStorageStrRev);
        System.out.println("------------------------------------diaobaole34------------------------------------");
        System.out.println(tempStorageStrRev.equals(tempStorageStr));
        System.out.println("------------------------------------diaobaole56------------------------------------");
        t = System.currentTimeMillis();
        byte[] decompressedOut = JDKDeflateUtils.decompress(tempStorageStrRev.getBytes("ISO-8859-1"));
        /**
         * java.util.zip.DataFormatException: incorrect header check
	at java.util.zip.Inflater.inflateBytes(Native Method)
	at java.util.zip.Inflater.inflate(Inflater.java:259)
	at java.util.zip.Inflater.inflate(Inflater.java:280)
	at com.immomo.wsconnector.main.JDKDeflateUtils.decompress(JDKDeflateUtils.java:68)
	at com.immomo.wsconnector.main.JDKDeflateUtils.main(JDKDeflateUtils.java:152)
         */
        System.out.println("解压缩后字节长度:\t" + decompressedOut.length+"  ,cost:"+(System.currentTimeMillis()-t));
        String outputStr = new String(decompressedOut);
        System.out.println("输出字符串:\t" + outputStr);
        System.out.println(inputStr.equals(outputStr));
        
    }
    
}
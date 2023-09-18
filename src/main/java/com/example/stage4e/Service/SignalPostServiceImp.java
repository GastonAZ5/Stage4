package com.example.stage4e.Service;

import com.example.stage4e.Entities.Post;
import com.example.stage4e.Entities.SignalPost;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.SignalServiceInterface;
import com.example.stage4e.Repository.PostRepository;
import com.example.stage4e.Repository.SignalRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SignalPostServiceImp implements SignalServiceInterface {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    SignalRepository signalRepository;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    EmailServiceImp mailingServiceInterface;



    public String AddSignalToPost(SignalPost signalPost, Integer IdUser, Integer IdPub) {
        User u = userRepository.findById(IdUser).get();
        Post pub = postRepository.findById(IdPub).get();
        System.out.println(pub.getSignalPosts().size());

//       Boolean confirmSignal=false;
//        User user = userServiceImp.findAdmins().get(0);
//        mailingServiceInterface.ConfirmSignalMail(user.getEmail());
//        && confirmSignal


        if (pub.getSignalPosts().size() > 1) {


                postRepository.deleteById(IdPub);
                mailingServiceInterface.sendEmail(pub.getPublierPar().getEmail(), "Post suppression ", "Your post has been deleted because of this content : " + pub.getContenu());
                return "This post has been deleted in order of many signals";
            } else
            {
            signalPost.setPost(pub);
            signalPost.setSignalPar(u);
            signalRepository.save(signalPost);
            return "Signal has been made successfuly";


        }
    }

//    public String ConfirmingSignal(){
//
//        String link = "http://localhost:9095/api/v1/auth/signalPost/confirm=" ;
//        SignalMail(link);
//        return "confirmed";
//    }
//
//
//
//    private String SignalMail(String link) {
//        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
//                "\n" +
//                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
//                "\n" +
//                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
//                "        \n" +
//                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
//                "          <tbody><tr>\n" +
//                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
//                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
//                "                  <tbody><tr>\n" +
//                "                    <td style=\"padding-left:10px\">\n" +
//                "                  \n" +
//                "                    </td>\n" +
//                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
//                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm Signal Post</span>\n" +
//                "                    </td>\n" +
//                "                  </tr>\n" +
//                "                </tbody></table>\n" +
//                "              </a>\n" +
//                "            </td>\n" +
//                "          </tr>\n" +
//                "        </tbody></table>\n" +
//                "        \n" +
//                "      </td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table>\n" +
//                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
//                "      <td>\n" +
//                "        \n" +
//                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
//                "                  <tbody><tr>\n" +
//                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
//                "                  </tr>\n" +
//                "                </tbody></table>\n" +
//                "        \n" +
//                "      </td>\n" +
//                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table>\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
//                "    <tbody><tr>\n" +
//                "      <td height=\"30\"><br></td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
//                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
//                "        \n" +
//                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi Admin "  + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Please click on the below link to confirm the post signal : </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
//                "        \n" +
//                "      </td>\n" +
//                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "      <td height=\"30\"><br></td>\n" +
//                "    </tr>\n" +
//                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
//                "\n" +
//                "</div></div>";
//    }

}

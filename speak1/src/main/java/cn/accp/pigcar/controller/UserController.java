package cn.accp.pigcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.UserService;
import cn.accp.pigcar.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
@CrossOrigin(allowCredentials = "true")
public class UserController{
    @Resource
    UserService userService;

    @RequestMapping(value="login")
    @ResponseBody
    public Object login(String userpwd, String username, HttpSession session){
        try {
            Users user = new Users();
            user.setUsername(username);
            user.setUserpwd(userpwd);
            Users user1 = userService.findUserByUNameAndPwd(user);
            //System.out.println("角色的id"+user1.getRoles().getRoleid());
            if (null == user1) {
                //表示登录失败,返回到登录界面
                return false;
            }

            List<Menus> menu = userService.findAllMenus(user1);
            System.out.println(menu);
            session.setAttribute("menus", menu);
            //登录成功,将user1对象信息设置到session
            session.setAttribute("user", user1);
            return  true;
        } catch (Exception e) {

            e.printStackTrace();
        }
        //如果发生异常，跳转到错误页面
        return  false;
    }

    @RequestMapping("getUserlogin")
    @ResponseBody
    public Map<String, Object> getLoginUser(HttpSession session){

        Map<String,Object> ld=new HashMap<>();
        ld.put("menu",session.getAttribute("menus"));
        ld.put("user",session.getAttribute("user"));
        return ld;
    }
    /**
     * 用户退出系统，注销session，返回登录界面
     *
     * */
    @RequestMapping("logout")
    @ResponseBody
    public Object logout(HttpServletRequest req){
        //注销session
        req.getSession().invalidate();
        return true;
    }
    /**
     * 查询所有角色信息，为查询用户信息做准备
     */
    @RequestMapping("findAllUsers")
    public String findAllRoles(HttpServletRequest req){
        List<Roles> roles = userService.findAllRoles();
        req.setAttribute("roles", roles);
        return "userManager/addUser";
    }

    @RequestMapping("addUsers")
    public String addUsers(Users user,HttpServletRequest req){
        boolean flag = userService.addUsers(user);
        if (flag) {
            return "forward:/car/user/findUserByPage";
        }
        //之后我们需要查询所有用户信息
        //List<Users> userList = userService.finAllUser();
        //req.setAttribute("userList", userList);
        //跳转到分页查询
        return "exception";
    }
    /**
     * 分页查询
     * @return
     */
    @RequestMapping("findUserByPage")
    public String findUserByPage(HttpServletRequest req){
        //获得当前页号
        String index = req.getParameter("currentPage");

        PageBean<Users> page = new PageBean<Users>();
        //查询所有用户，获得总记录数量
        List<Users> list = userService.finAllUser();
        page.setTotalCount(list.size());
        int currentIndex=1;
        if (null != index && !"".equals(index) ) {
            currentIndex = Integer.parseInt(index);
        }
        //设置当前页
        System.out.println("当前页："+currentIndex);
        page.setIndex(currentIndex);
        List<Users> userList = userService.findUserByPage(page);
        req.setAttribute("pageIndex", currentIndex);
        req.setAttribute("page", page);
        req.setAttribute("userList", userList);
        return "userManager/viewUser";
    }

    /**
     * 查询所有角色信息，为条件查询用户信息做准备
     * @param req
     * @return
     */
    @RequestMapping("findAllRoles")
    public String findAllRoles1(HttpServletRequest req){
        List<Roles> roles = userService.findAllRoles();
        req.setAttribute("roles", roles);
        return "userManager/findUser";
    }
    /**
     * 多条件分页查询用户信息
     * @param user
     * @param req
     * @return
     */
    @RequestMapping("findUserByIf")
    public String findUserByIf(Users user,HttpServletRequest req){
        //获得当前页号
        String index = req.getParameter("currentPage");
        PageBean<Users> page = new PageBean<Users>();
        //多条件查询的所有结果
        List<Users> byIfList = userService.findUserByIf(user);
        page.setSize(byIfList.size());
        int currentIndex = 1;

        if (null != index && !"".equals(index) ) {
            currentIndex = Integer.parseInt(index);
        }
        //设置当前页
        System.out.println("当前页："+currentIndex);
        page.setIndex(currentIndex);
        //多条件的分页查询
        List<Users> list = userService.findUserByIf(user, page);
        //System.out.println(list.get(1).getRoles().getRolename());
        req.setAttribute("pageIndex", currentIndex);
        req.setAttribute("page", page);
        //req.setAttribute("userList", list);
        req.setAttribute("userList", list);
        return "userManager/viewUserByPage";
    }
    /**
     * 跟新用户信息之前先要通过用户主键查询信息，将信息显示在更新界面
     * @param username
     * @param req
     * @return
     */
    @RequestMapping("preUpdate")
    public String preUpdate(String username,HttpServletRequest req){
        //跟新之前也得做几件事，得先查询role表和用户表
        //需要查出角色的集合
        List<Roles> roles = userService.findAllRoles();
        Users user = userService.findUserInfoByUName(username);
        req.setAttribute("roles", roles);
        req.setAttribute("obj", user);
        return "userManager/updateUser";
    }
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    public String updateUser(Users user){
        boolean flag = userService.updateUsers(user);
        if (flag) {
            //修改成功
            return "forward:/car/user/findUserByPage";
        }
        return "exception";
    }
    /**
     * 删除用户信息
     * @param username
     * @return
     */
    @RequestMapping("deleteUser")
    public String deleteMapper(String username){
        boolean flag = userService.deleteUserByUsername(username);
        if (flag) {
            //删除成功
            return "forward:/car/user/findUserByPage";
        }
        return "exception";
    }
    /**
     * 更新密码之前先查询数据
     * @param username
     * @param req
     * @return
     */
    @RequestMapping("preUpdatePwd")
    public String preUpdatePwd(String username,HttpServletRequest req){
        //更新之前先查询数据，然后，将数据显示到界面
        Users user = userService.findUserInfoByUName(username);
        req.setAttribute("user", user);
        return "userManager/changeUserPwd";
    }
    /**
     * 更新密码
     * @param okNewPwd
     * @param userName
     * @return
     */
    @RequestMapping("updatePwd")
    public String updatePwd(String okNewPwd,String userName){
        Users user = new Users();
        user.setUsername(userName);
        user.setUserpwd(okNewPwd);
        boolean flag = userService.updateUsers(user);
        if (flag) {
            //修改成功
            return "forward:/car/user/findUserByPage";
        }
        return "exception";
    }

}
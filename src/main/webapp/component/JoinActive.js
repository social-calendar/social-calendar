//活动详情
import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';
import Formate from './Formate.js';

import Paper from 'material-ui/Paper';
import {List, ListItem} from 'material-ui/List';
import Avatar from 'material-ui/Avatar';
import {tealA700} from 'material-ui/styles/colors';
import Divider from 'material-ui/Divider';
import Subheader from 'material-ui/Subheader';
import {Card, CardActions, CardHeader, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';
import FlatButton from 'material-ui/FlatButton';
import FloatingActionButton from 'material-ui/FloatingActionButton';


//svg图标
import ActionAssignment from 'material-ui/svg-icons/action/assignment';
import DeviceAccessTime from 'material-ui/svg-icons/device/access-time';
import Place from 'material-ui/svg-icons/maps/place';
import Notifications from 'material-ui/svg-icons/social/notifications';
import Share from 'material-ui/svg-icons/social/share';
import ChevronRight from 'material-ui/svg-icons/navigation/chevron-right';
import Edit from 'material-ui/svg-icons/image/edit';
import Editor from 'material-ui/svg-icons/editor/border-color';

injectTapEventPlugin();

const paperStyle={
    marginBottom:20,
};

const avatarStyle={
    marginLeft:10
};

const shareStyle={
    width:'100%'
};

const editButton={
    position:'fixed',
    right:0,
    bottom:30,
}
const bannerStyle={
    banner:{
        backgroundImage:"url(images/banner.jpg)",
        height:200,
        overflow:'hidden',
        marginTop:-10,
        marginLeft:-2
    },
    avatar:{
        position:'relative',
        left:'40%',
        top:20
    },
    text:{
        color:'white',
        textAlign:'center',
        position:'relative',
        top:20
    }
}
class JoinActive extends React.Component{
    constructor(props) {
        super(props);
        this.componentDidMount=this.componentDidMount.bind(this);
        this.handleTouchTap=this.handleTouchTap.bind(this);

        this.state={
            data:{},
            commentList:[],
            AvatarArray:[]
        }
    }
    componentDidMount(){
        var _this=this;
        var activeId = location.search;
        $.ajax({
            url:"/app/java/getActiveDetail.do"+activeId,
            type:'GET',
            success:function (result) {
                if (result.hasJoined) {//如果已经加入活动，就跳到详情页
                    location.href='detail.html'+activeId;
                }else{
                   _this.setState({
                        data:result,
                        commentList:result.commentList,
                        AvatarArray:result.AvatarArray
                    }); 
                }
                
            },
            error:function (xhr,error) {
                console.log(error);
            }
        });
    }
    handleTouchTap(event){
        var _this=this;
        var activeId = location.search;
        $.ajax({
            type:"POST",
            url:"/app/java/joinActive.do",
            contentType:"application/json; charset=utf-8",
            data:JSON.stringify({
                activeId:(location.search.split('='))[1],                        
            }),
            success:function (result) {
               if (result.status===1) {
                    console.log('test');
                    location.href="detail.html"+activeId;
               }else{
                    alert('加入失败!');
               }
            },
            error:function (xhr,error) {
                console.log('touch '+error);
            }
        });
    }
    render(){
        return(
            <div>
                <Paper zDepth={0} style={paperStyle}>
                    <List>
                        <div style={bannerStyle.banner}>
                            <Avatar src={this.state.data.authorAvatar} size={80} style={bannerStyle.avatar}/>
                            <div style={bannerStyle.text}>
                                 <p>{this.state.data.author}创建</p>
                                 <h2>邀请你加入这个活动</h2>
                            </div>
                        </div>
                        <ListItem
                            leftIcon={<ActionAssignment />}
                            primaryText={this.state.data.activeTheme}
                        />
                        <ListItem 
                            leftIcon={<DeviceAccessTime/>}
                            primaryText={this.state.data.startTime+"--"+this.state.data.endTime}
                        />
                        <ListItem
                            leftIcon={<Place/>}
                            primaryText={this.state.data.place}
                        />
                        <ListItem
                            leftIcon={<Notifications/>}
                            primaryText={"提前"+this.state.data.alarm+"分钟提醒"}
                        />                         
                    </List>
                </Paper>
                
                <Paper zDepth={0} style={paperStyle}>
                    <List>
                            <ListItem 
                                primaryText={"活动讨论("+this.state.data.commentLength+"条讨论)"} 
                                href={"comment.html?activeId="+this.state.data.activeId}
                                rightIcon={<ChevronRight/>}
                            />
                            <Divider/>
                            {
                                this.state.commentList.map(function (comment,index) {
                                   return(
                                        <div key={index}>
                                            <ListItem                                               
                                                leftAvatar={<Avatar src={comment.userAvatar}/>}
                                                primaryText={comment.userName}
                                                secondaryText={comment.content}
                                                secondaryTextLines={2}
                                                rightIcon={<span style={{width:'auto'}}>{comment.time}</span>}                               
                                            />
                                            <Divider />
                                        </div>
                                    )
                                })
                            }
                            
                    </List>
                </Paper>

                <Paper zDepth={0} style={paperStyle}>
                    <Card>
                        <CardHeader
                            title="活动详情"
                        />
                        <Divider/>
                        <CardText>
                            {this.state.data.activeDetail}
                        </CardText>
                    </Card>
                </Paper>
                <RaisedButton 
                    label="加入活动" 
                    primary={true} 
                    onTouchTap={this.handleTouchTap}
                    style={{width:'100%',height:50,fontSize:'20px'}}
                />
            </div>          
        )
    }
}



ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <JoinActive />
   </MuiThemeProvider>,
   document.getElementsByClassName('join')[0] 
);

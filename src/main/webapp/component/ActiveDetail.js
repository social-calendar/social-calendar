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

class ActiveDetail extends React.Component{
	constructor(props) {
        super(props);
        this.componentDidMount=this.componentDidMount.bind(this);

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
            url:"/app/java/getActiveDetail.do" + activeId + '&url=' + encodeURIComponent(location.href.split('#')[0]),
            type:'GET',
            success:function (result) {
                if (result.hasJoined) {
                    var appId = result.config.appId,
                        timestamp = result.config.timestamp,
                        nonceStr = result.config.nonceStr,
                        signature = result.config.signature;
                    var commonContent = {
                        title: result.activeTheme,
                        desc:'你有一条来自[社交日历]的邀约!<br/>点击查看详情',
                        link: location.origin + location.pathname + location.search,
                        imgUrl: result.authorAvatar,
                        success: function () {
                            /* 暂时为空 */
                        },
                        cancel: function () {
                             /* 暂时为空 */ 
                        }
                    };
                    _this.setState({
                        data:result,
                        commentList:result.commentList,
                        AvatarArray:result.AvatarArray,
                    });
                    // 微信
                    wx.config({
                        debug: false,
                        appId: appId,
                        timestamp: timestamp,
                        nonceStr: nonceStr,
                        signature: signature,
                        jsApiList: [
                            'onMenuShareTimeline',
                            'onMenuShareAppMessage'
                            'onMenuShareQQ',
                            'onMenuShareQZone'
                        ]
                    });
                    wx.ready(function () {
                        // 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
                        wx.onMenuShareTimeline(commonContent);
                        commonContent.desc = result.activeDetail;
                        wx.onMenuShareAppMessage(commonContent);
                        wx.onMenuShareQQ(commonContent);
                        wx.onMenuShareQZone(commonContent);
                    });
                    wx.error(function (res) {
                        var res = JSON.stringify(res);
                        alert('错误信息：' + res);
                    });
                }else{//如果没有加入就跳到加入活动页面
                    location.href='join.html' + activeId;
                }
               
            },
            error:function (xhr,error) {
                console.log(error);
            }
        });
    }
    render(){
    	return(
    		<div>
    			<Paper zDepth={0} style={paperStyle}>
		    		<List>
		    			<ListItem
		    				leftAvatar={<Avatar src={this.state.data.authorAvatar} />}
		    				primaryText={this.state.data.author}
		        			secondaryText="创建了活动"
		    			/>
		    			<Divider/>
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
		    			<Divider/>
		    			<ListItem primaryText={"共"+this.state.data.partInNum+"人参加了活动"} style={{fontSize:'12px'}}/>		    			
		    			{
                            this.state.AvatarArray.map(function (imgURL,index) {
                                return <Avatar key={new Date()+index} src={imgURL} style={avatarStyle}/>   
                            })
                        }					
    					<RaisedButton 
    						label="点击右上角分享给微信好友" 
    						primary={true}   
    						icon={<Share/>}
    						style={shareStyle}
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

                <Paper zDepth={0} >
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
                {this.state.data.isCreater?
                    <FloatingActionButton secondary={true} style={editButton} href={"edit.html?activeId="+this.state.data.activeId} linkButton={true}>
                        <Edit/>
                    </FloatingActionButton>
                    :
                    ''
                }
                
    		</div>    		
    	)
    }
}



ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <ActiveDetail />
   </MuiThemeProvider>,
   document.getElementsByClassName('detail')[0] 
);

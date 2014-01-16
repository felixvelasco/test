package com.isb.bks.ivr.voice.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVoiceDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'output'", "'menu'", "'input'", "'record'", "'filename'", "'blindTransfer'", "'consultationTransfer'", "'bridgeTransfer'", "'destination'", "'audioTransfer'", "'maxTime'", "'timeout'", "'grammars'", "'{'", "'}'", "'audios'", "'main'", "':'", "'match'", "'nomatch'", "'noinput'", "'ms'", "'s'", "'true'", "'false'", "'voice'", "'dtmf'", "'voicedtmf'", "'expr'", "'condition'", "'options'", "','", "'*'", "'say'", "'src'", "'wording'", "'as'", "'('", "')'", "'when'", "'number'", "'boolean'", "'currency'", "'date'", "'digits'", "'phone'", "'time'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_FLOAT=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalVoiceDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVoiceDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVoiceDslParser.tokenNames; }
    public String getGrammarFileName() { return "../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g"; }



     	private VoiceDslGrammarAccess grammarAccess;
     	
        public InternalVoiceDslParser(TokenStream input, VoiceDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "VoiceDsl";	
       	}
       	
       	@Override
       	protected VoiceDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleVoiceDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:68:1: entryRuleVoiceDsl returns [EObject current=null] : iv_ruleVoiceDsl= ruleVoiceDsl EOF ;
    public final EObject entryRuleVoiceDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoiceDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:69:2: (iv_ruleVoiceDsl= ruleVoiceDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:70:2: iv_ruleVoiceDsl= ruleVoiceDsl EOF
            {
             newCompositeNode(grammarAccess.getVoiceDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVoiceDsl_in_entryRuleVoiceDsl75);
            iv_ruleVoiceDsl=ruleVoiceDsl();

            state._fsp--;

             current =iv_ruleVoiceDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVoiceDsl85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoiceDsl"


    // $ANTLR start "ruleVoiceDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:77:1: ruleVoiceDsl returns [EObject current=null] : (this_InputDsl_0= ruleInputDsl | this_MenuDsl_1= ruleMenuDsl | this_PromptDsl_2= rulePromptDsl | this_RecordDsl_3= ruleRecordDsl | this_TransferDsl_4= ruleTransferDsl ) ;
    public final EObject ruleVoiceDsl() throws RecognitionException {
        EObject current = null;

        EObject this_InputDsl_0 = null;

        EObject this_MenuDsl_1 = null;

        EObject this_PromptDsl_2 = null;

        EObject this_RecordDsl_3 = null;

        EObject this_TransferDsl_4 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:80:28: ( (this_InputDsl_0= ruleInputDsl | this_MenuDsl_1= ruleMenuDsl | this_PromptDsl_2= rulePromptDsl | this_RecordDsl_3= ruleRecordDsl | this_TransferDsl_4= ruleTransferDsl ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:81:1: (this_InputDsl_0= ruleInputDsl | this_MenuDsl_1= ruleMenuDsl | this_PromptDsl_2= rulePromptDsl | this_RecordDsl_3= ruleRecordDsl | this_TransferDsl_4= ruleTransferDsl )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:81:1: (this_InputDsl_0= ruleInputDsl | this_MenuDsl_1= ruleMenuDsl | this_PromptDsl_2= rulePromptDsl | this_RecordDsl_3= ruleRecordDsl | this_TransferDsl_4= ruleTransferDsl )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            case 17:
            case 18:
            case 19:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:82:5: this_InputDsl_0= ruleInputDsl
                    {
                     
                            newCompositeNode(grammarAccess.getVoiceDslAccess().getInputDslParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInputDsl_in_ruleVoiceDsl132);
                    this_InputDsl_0=ruleInputDsl();

                    state._fsp--;

                     
                            current = this_InputDsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:92:5: this_MenuDsl_1= ruleMenuDsl
                    {
                     
                            newCompositeNode(grammarAccess.getVoiceDslAccess().getMenuDslParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMenuDsl_in_ruleVoiceDsl159);
                    this_MenuDsl_1=ruleMenuDsl();

                    state._fsp--;

                     
                            current = this_MenuDsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:102:5: this_PromptDsl_2= rulePromptDsl
                    {
                     
                            newCompositeNode(grammarAccess.getVoiceDslAccess().getPromptDslParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePromptDsl_in_ruleVoiceDsl186);
                    this_PromptDsl_2=rulePromptDsl();

                    state._fsp--;

                     
                            current = this_PromptDsl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:112:5: this_RecordDsl_3= ruleRecordDsl
                    {
                     
                            newCompositeNode(grammarAccess.getVoiceDslAccess().getRecordDslParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecordDsl_in_ruleVoiceDsl213);
                    this_RecordDsl_3=ruleRecordDsl();

                    state._fsp--;

                     
                            current = this_RecordDsl_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:122:5: this_TransferDsl_4= ruleTransferDsl
                    {
                     
                            newCompositeNode(grammarAccess.getVoiceDslAccess().getTransferDslParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTransferDsl_in_ruleVoiceDsl240);
                    this_TransferDsl_4=ruleTransferDsl();

                    state._fsp--;

                     
                            current = this_TransferDsl_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoiceDsl"


    // $ANTLR start "entryRulePromptDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:138:1: entryRulePromptDsl returns [EObject current=null] : iv_rulePromptDsl= rulePromptDsl EOF ;
    public final EObject entryRulePromptDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePromptDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:139:2: (iv_rulePromptDsl= rulePromptDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:140:2: iv_rulePromptDsl= rulePromptDsl EOF
            {
             newCompositeNode(grammarAccess.getPromptDslRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePromptDsl_in_entryRulePromptDsl275);
            iv_rulePromptDsl=rulePromptDsl();

            state._fsp--;

             current =iv_rulePromptDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePromptDsl285); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePromptDsl"


    // $ANTLR start "rulePromptDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:147:1: rulePromptDsl returns [EObject current=null] : (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_5_0= ruleAudios ) ) ) ;
    public final EObject rulePromptDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_configuration_3_0 = null;

        EObject lv_conditions_4_0 = null;

        EObject lv_audios_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:150:28: ( (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_5_0= ruleAudios ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:151:1: (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_5_0= ruleAudios ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:151:1: (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_5_0= ruleAudios ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:151:3: otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_5_0= ruleAudios ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_rulePromptDsl322); 

                	newLeafNode(otherlv_0, grammarAccess.getPromptDslAccess().getOutputKeyword_0());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:155:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:156:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:156:1: (lv_name_1_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:157:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePromptDsl339); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPromptDslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPromptDslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:173:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:175:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:175:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:176:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getPromptDslAccess().getUnorderedGroup_2());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:179:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:180:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:180:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( LA3_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 0) ) {
                    alt3=1;
                }
                else if ( LA3_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 1) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:182:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:182:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:183:5: {...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePromptDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:183:106: ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:184:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:187:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:187:7: {...}? => ( (lv_configuration_3_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePromptDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:187:16: ( (lv_configuration_3_0= ruleConfiguration ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:188:1: (lv_configuration_3_0= ruleConfiguration )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:188:1: (lv_configuration_3_0= ruleConfiguration )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:189:3: lv_configuration_3_0= ruleConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPromptDslAccess().getConfigurationConfigurationParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_rulePromptDsl410);
            	    lv_configuration_3_0=ruleConfiguration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPromptDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"configuration",
            	            		lv_configuration_3_0, 
            	            		"Configuration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPromptDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:212:4: ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:212:4: ({...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:213:5: {...}? => ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePromptDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:213:106: ( ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:214:6: ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getPromptDslAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:217:6: ({...}? => ( (lv_conditions_4_0= ruleCondition ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==41) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:217:7: {...}? => ( (lv_conditions_4_0= ruleCondition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "rulePromptDsl", "true");
            	    	    }
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:217:16: ( (lv_conditions_4_0= ruleCondition ) )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:218:1: (lv_conditions_4_0= ruleCondition )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:218:1: (lv_conditions_4_0= ruleCondition )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:219:3: lv_conditions_4_0= ruleCondition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getPromptDslAccess().getConditionsConditionParserRuleCall_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleCondition_in_rulePromptDsl485);
            	    	    lv_conditions_4_0=ruleCondition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getPromptDslRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"conditions",
            	    	            		lv_conditions_4_0, 
            	    	            		"Condition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPromptDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPromptDslAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "rulePromptDsl", "getUnorderedGroupHelper().canLeave(grammarAccess.getPromptDslAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getPromptDslAccess().getUnorderedGroup_2());
            	

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:250:2: ( (lv_audios_5_0= ruleAudios ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:251:1: (lv_audios_5_0= ruleAudios )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:251:1: (lv_audios_5_0= ruleAudios )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:252:3: lv_audios_5_0= ruleAudios
            {
             
            	        newCompositeNode(grammarAccess.getPromptDslAccess().getAudiosAudiosParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_rulePromptDsl553);
            lv_audios_5_0=ruleAudios();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPromptDslRule());
            	        }
                   		set(
                   			current, 
                   			"audios",
                    		lv_audios_5_0, 
                    		"Audios");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePromptDsl"


    // $ANTLR start "entryRuleMenuDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:276:1: entryRuleMenuDsl returns [EObject current=null] : iv_ruleMenuDsl= ruleMenuDsl EOF ;
    public final EObject entryRuleMenuDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMenuDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:277:2: (iv_ruleMenuDsl= ruleMenuDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:278:2: iv_ruleMenuDsl= ruleMenuDsl EOF
            {
             newCompositeNode(grammarAccess.getMenuDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMenuDsl_in_entryRuleMenuDsl589);
            iv_ruleMenuDsl=ruleMenuDsl();

            state._fsp--;

             current =iv_ruleMenuDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMenuDsl599); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMenuDsl"


    // $ANTLR start "ruleMenuDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:285:1: ruleMenuDsl returns [EObject current=null] : (otherlv_0= 'menu' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ( (lv_outputs_7_0= ruleOutputs ) ) ) ;
    public final EObject ruleMenuDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_configuration_3_0 = null;

        EObject lv_grammars_4_0 = null;

        EObject lv_conditions_5_0 = null;

        EObject lv_audios_6_0 = null;

        EObject lv_outputs_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:288:28: ( (otherlv_0= 'menu' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ( (lv_outputs_7_0= ruleOutputs ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:289:1: (otherlv_0= 'menu' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ( (lv_outputs_7_0= ruleOutputs ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:289:1: (otherlv_0= 'menu' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ( (lv_outputs_7_0= ruleOutputs ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:289:3: otherlv_0= 'menu' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ( (lv_outputs_7_0= ruleOutputs ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMenuDsl636); 

                	newLeafNode(otherlv_0, grammarAccess.getMenuDslAccess().getMenuKeyword_0());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:293:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:294:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:294:1: (lv_name_1_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:295:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMenuDsl653); 

            			newLeafNode(lv_name_1_0, grammarAccess.getMenuDslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMenuDslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:311:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:313:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:313:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:314:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getMenuDslAccess().getUnorderedGroup_2());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:317:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:318:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:318:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=4;
                int LA5_0 = input.LA(1);

                if ( LA5_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 2) ) {
                    alt5=3;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:320:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:320:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:321:5: {...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleMenuDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:321:104: ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:322:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:325:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:325:7: {...}? => ( (lv_configuration_3_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMenuDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:325:16: ( (lv_configuration_3_0= ruleConfiguration ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:326:1: (lv_configuration_3_0= ruleConfiguration )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:326:1: (lv_configuration_3_0= ruleConfiguration )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:327:3: lv_configuration_3_0= ruleConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMenuDslAccess().getConfigurationConfigurationParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_ruleMenuDsl724);
            	    lv_configuration_3_0=ruleConfiguration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMenuDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"configuration",
            	            		lv_configuration_3_0, 
            	            		"Configuration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMenuDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:350:4: ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:350:4: ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:351:5: {...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleMenuDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:351:104: ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:352:6: ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:355:6: ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:355:7: {...}? => ( (lv_grammars_4_0= ruleGrammars ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMenuDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:355:16: ( (lv_grammars_4_0= ruleGrammars ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:356:1: (lv_grammars_4_0= ruleGrammars )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:356:1: (lv_grammars_4_0= ruleGrammars )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:357:3: lv_grammars_4_0= ruleGrammars
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMenuDslAccess().getGrammarsGrammarsParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleGrammars_in_ruleMenuDsl799);
            	    lv_grammars_4_0=ruleGrammars();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMenuDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"grammars",
            	            		lv_grammars_4_0, 
            	            		"Grammars");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMenuDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:380:4: ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:380:4: ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:381:5: {...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleMenuDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:381:104: ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:382:6: ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMenuDslAccess().getUnorderedGroup_2(), 2);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:385:6: ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==41) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:385:7: {...}? => ( (lv_conditions_5_0= ruleCondition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleMenuDsl", "true");
            	    	    }
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:385:16: ( (lv_conditions_5_0= ruleCondition ) )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:386:1: (lv_conditions_5_0= ruleCondition )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:386:1: (lv_conditions_5_0= ruleCondition )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:387:3: lv_conditions_5_0= ruleCondition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getMenuDslAccess().getConditionsConditionParserRuleCall_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleCondition_in_ruleMenuDsl874);
            	    	    lv_conditions_5_0=ruleCondition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getMenuDslRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"conditions",
            	    	            		lv_conditions_5_0, 
            	    	            		"Condition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMenuDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMenuDslAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleMenuDsl", "getUnorderedGroupHelper().canLeave(grammarAccess.getMenuDslAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getMenuDslAccess().getUnorderedGroup_2());
            	

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:418:2: ( (lv_audios_6_0= ruleAudios ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:419:1: (lv_audios_6_0= ruleAudios )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:419:1: (lv_audios_6_0= ruleAudios )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:420:3: lv_audios_6_0= ruleAudios
            {
             
            	        newCompositeNode(grammarAccess.getMenuDslAccess().getAudiosAudiosParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_ruleMenuDsl942);
            lv_audios_6_0=ruleAudios();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMenuDslRule());
            	        }
                   		set(
                   			current, 
                   			"audios",
                    		lv_audios_6_0, 
                    		"Audios");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:436:2: ( (lv_outputs_7_0= ruleOutputs ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:437:1: (lv_outputs_7_0= ruleOutputs )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:437:1: (lv_outputs_7_0= ruleOutputs )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:438:3: lv_outputs_7_0= ruleOutputs
            {
             
            	        newCompositeNode(grammarAccess.getMenuDslAccess().getOutputsOutputsParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOutputs_in_ruleMenuDsl963);
            lv_outputs_7_0=ruleOutputs();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMenuDslRule());
            	        }
                   		set(
                   			current, 
                   			"outputs",
                    		lv_outputs_7_0, 
                    		"Outputs");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMenuDsl"


    // $ANTLR start "entryRuleInputDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:462:1: entryRuleInputDsl returns [EObject current=null] : iv_ruleInputDsl= ruleInputDsl EOF ;
    public final EObject entryRuleInputDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:463:2: (iv_ruleInputDsl= ruleInputDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:464:2: iv_ruleInputDsl= ruleInputDsl EOF
            {
             newCompositeNode(grammarAccess.getInputDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInputDsl_in_entryRuleInputDsl999);
            iv_ruleInputDsl=ruleInputDsl();

            state._fsp--;

             current =iv_ruleInputDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInputDsl1009); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputDsl"


    // $ANTLR start "ruleInputDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:471:1: ruleInputDsl returns [EObject current=null] : (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ) ;
    public final EObject ruleInputDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_configuration_3_0 = null;

        EObject lv_grammars_4_0 = null;

        EObject lv_conditions_5_0 = null;

        EObject lv_audios_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:474:28: ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:475:1: (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:475:1: (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:475:3: otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_6_0= ruleAudios ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInputDsl1046); 

                	newLeafNode(otherlv_0, grammarAccess.getInputDslAccess().getInputKeyword_0());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:479:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:480:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:480:1: (lv_name_1_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInputDsl1063); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInputDslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInputDslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:497:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:499:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:499:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:500:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getInputDslAccess().getUnorderedGroup_2());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:503:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:504:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:504:3: ( ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( LA7_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 2) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:506:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:506:4: ({...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:507:5: {...}? => ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleInputDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:507:105: ( ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:508:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:511:6: ({...}? => ( (lv_configuration_3_0= ruleConfiguration ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:511:7: {...}? => ( (lv_configuration_3_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleInputDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:511:16: ( (lv_configuration_3_0= ruleConfiguration ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:512:1: (lv_configuration_3_0= ruleConfiguration )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:512:1: (lv_configuration_3_0= ruleConfiguration )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:513:3: lv_configuration_3_0= ruleConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInputDslAccess().getConfigurationConfigurationParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_ruleInputDsl1134);
            	    lv_configuration_3_0=ruleConfiguration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInputDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"configuration",
            	            		lv_configuration_3_0, 
            	            		"Configuration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInputDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:536:4: ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:536:4: ({...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:537:5: {...}? => ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleInputDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:537:105: ( ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:538:6: ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:541:6: ({...}? => ( (lv_grammars_4_0= ruleGrammars ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:541:7: {...}? => ( (lv_grammars_4_0= ruleGrammars ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleInputDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:541:16: ( (lv_grammars_4_0= ruleGrammars ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:542:1: (lv_grammars_4_0= ruleGrammars )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:542:1: (lv_grammars_4_0= ruleGrammars )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:543:3: lv_grammars_4_0= ruleGrammars
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInputDslAccess().getGrammarsGrammarsParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleGrammars_in_ruleInputDsl1209);
            	    lv_grammars_4_0=ruleGrammars();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInputDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"grammars",
            	            		lv_grammars_4_0, 
            	            		"Grammars");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInputDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:566:4: ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:566:4: ({...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:567:5: {...}? => ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleInputDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:567:105: ( ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:568:6: ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getInputDslAccess().getUnorderedGroup_2(), 2);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:571:6: ({...}? => ( (lv_conditions_5_0= ruleCondition ) ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==41) ) {
            	            int LA6_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt6=1;
            	            }


            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:571:7: {...}? => ( (lv_conditions_5_0= ruleCondition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleInputDsl", "true");
            	    	    }
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:571:16: ( (lv_conditions_5_0= ruleCondition ) )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:572:1: (lv_conditions_5_0= ruleCondition )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:572:1: (lv_conditions_5_0= ruleCondition )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:573:3: lv_conditions_5_0= ruleCondition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getInputDslAccess().getConditionsConditionParserRuleCall_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleCondition_in_ruleInputDsl1284);
            	    	    lv_conditions_5_0=ruleCondition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getInputDslRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"conditions",
            	    	            		lv_conditions_5_0, 
            	    	            		"Condition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getInputDslAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getInputDslAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleInputDsl", "getUnorderedGroupHelper().canLeave(grammarAccess.getInputDslAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getInputDslAccess().getUnorderedGroup_2());
            	

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:604:2: ( (lv_audios_6_0= ruleAudios ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:605:1: (lv_audios_6_0= ruleAudios )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:605:1: (lv_audios_6_0= ruleAudios )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:606:3: lv_audios_6_0= ruleAudios
            {
             
            	        newCompositeNode(grammarAccess.getInputDslAccess().getAudiosAudiosParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_ruleInputDsl1352);
            lv_audios_6_0=ruleAudios();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInputDslRule());
            	        }
                   		set(
                   			current, 
                   			"audios",
                    		lv_audios_6_0, 
                    		"Audios");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputDsl"


    // $ANTLR start "entryRuleRecordDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:630:1: entryRuleRecordDsl returns [EObject current=null] : iv_ruleRecordDsl= ruleRecordDsl EOF ;
    public final EObject entryRuleRecordDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:631:2: (iv_ruleRecordDsl= ruleRecordDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:632:2: iv_ruleRecordDsl= ruleRecordDsl EOF
            {
             newCompositeNode(grammarAccess.getRecordDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecordDsl_in_entryRuleRecordDsl1388);
            iv_ruleRecordDsl=ruleRecordDsl();

            state._fsp--;

             current =iv_ruleRecordDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecordDsl1398); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordDsl"


    // $ANTLR start "ruleRecordDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:639:1: ruleRecordDsl returns [EObject current=null] : (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'filename' ( (lv_fileName_3_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_7_0= ruleAudios ) ) ) ;
    public final EObject ruleRecordDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_fileName_3_0=null;
        EObject lv_configuration_5_0 = null;

        EObject lv_conditions_6_0 = null;

        EObject lv_audios_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:642:28: ( (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'filename' ( (lv_fileName_3_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_7_0= ruleAudios ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:643:1: (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'filename' ( (lv_fileName_3_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_7_0= ruleAudios ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:643:1: (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'filename' ( (lv_fileName_3_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_7_0= ruleAudios ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:643:3: otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'filename' ( (lv_fileName_3_0= RULE_STRING ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) ) ( (lv_audios_7_0= ruleAudios ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRecordDsl1435); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordDslAccess().getRecordKeyword_0());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:647:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:648:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:648:1: (lv_name_1_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:649:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecordDsl1452); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRecordDslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRecordDslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRecordDsl1469); 

                	newLeafNode(otherlv_2, grammarAccess.getRecordDslAccess().getFilenameKeyword_2());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:669:1: ( (lv_fileName_3_0= RULE_STRING ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:670:1: (lv_fileName_3_0= RULE_STRING )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:670:1: (lv_fileName_3_0= RULE_STRING )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:671:3: lv_fileName_3_0= RULE_STRING
            {
            lv_fileName_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRecordDsl1486); 

            			newLeafNode(lv_fileName_3_0, grammarAccess.getRecordDslAccess().getFileNameSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRecordDslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"fileName",
                    		lv_fileName_3_0, 
                    		"STRING");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:687:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:689:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:689:1: ( ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:690:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRecordDslAccess().getUnorderedGroup_4());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:693:2: ( ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:694:3: ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:694:3: ( ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( LA9_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 0) ) {
                    alt9=1;
                }
                else if ( LA9_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 1) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:696:4: ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:696:4: ({...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:697:5: {...}? => ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRecordDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:697:106: ( ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:698:6: ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:701:6: ({...}? => ( (lv_configuration_5_0= ruleConfiguration ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:701:7: {...}? => ( (lv_configuration_5_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRecordDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:701:16: ( (lv_configuration_5_0= ruleConfiguration ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:702:1: (lv_configuration_5_0= ruleConfiguration )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:702:1: (lv_configuration_5_0= ruleConfiguration )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:703:3: lv_configuration_5_0= ruleConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordDslAccess().getConfigurationConfigurationParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_ruleRecordDsl1557);
            	    lv_configuration_5_0=ruleConfiguration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecordDslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"configuration",
            	            		lv_configuration_5_0, 
            	            		"Configuration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRecordDslAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:726:4: ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:726:4: ({...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:727:5: {...}? => ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRecordDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:727:106: ( ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:728:6: ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRecordDslAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:731:6: ({...}? => ( (lv_conditions_6_0= ruleCondition ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==41) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:731:7: {...}? => ( (lv_conditions_6_0= ruleCondition ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRecordDsl", "true");
            	    	    }
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:731:16: ( (lv_conditions_6_0= ruleCondition ) )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:732:1: (lv_conditions_6_0= ruleCondition )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:732:1: (lv_conditions_6_0= ruleCondition )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:733:3: lv_conditions_6_0= ruleCondition
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRecordDslAccess().getConditionsConditionParserRuleCall_4_1_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleCondition_in_ruleRecordDsl1632);
            	    	    lv_conditions_6_0=ruleCondition();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRecordDslRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"conditions",
            	    	            		lv_conditions_6_0, 
            	    	            		"Condition");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRecordDslAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getRecordDslAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleRecordDsl", "getUnorderedGroupHelper().canLeave(grammarAccess.getRecordDslAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRecordDslAccess().getUnorderedGroup_4());
            	

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:764:2: ( (lv_audios_7_0= ruleAudios ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:765:1: (lv_audios_7_0= ruleAudios )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:765:1: (lv_audios_7_0= ruleAudios )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:766:3: lv_audios_7_0= ruleAudios
            {
             
            	        newCompositeNode(grammarAccess.getRecordDslAccess().getAudiosAudiosParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_ruleRecordDsl1700);
            lv_audios_7_0=ruleAudios();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRecordDslRule());
            	        }
                   		set(
                   			current, 
                   			"audios",
                    		lv_audios_7_0, 
                    		"Audios");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordDsl"


    // $ANTLR start "entryRuleTransferDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:790:1: entryRuleTransferDsl returns [EObject current=null] : iv_ruleTransferDsl= ruleTransferDsl EOF ;
    public final EObject entryRuleTransferDsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransferDsl = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:791:2: (iv_ruleTransferDsl= ruleTransferDsl EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:792:2: iv_ruleTransferDsl= ruleTransferDsl EOF
            {
             newCompositeNode(grammarAccess.getTransferDslRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransferDsl_in_entryRuleTransferDsl1736);
            iv_ruleTransferDsl=ruleTransferDsl();

            state._fsp--;

             current =iv_ruleTransferDsl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransferDsl1746); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransferDsl"


    // $ANTLR start "ruleTransferDsl"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:799:1: ruleTransferDsl returns [EObject current=null] : ( ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_conditions_15_0= ruleCondition ) )? ( (lv_audios_16_0= ruleAudios ) ) ) ;
    public final EObject ruleTransferDsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_7=null;
        Token lv_destination_8_0=null;
        Token otherlv_9=null;
        Token lv_audioTransfer_10_0=null;
        Token otherlv_11=null;
        Token lv_maxTime_12_0=null;
        Token otherlv_13=null;
        Token lv_timeout_14_0=null;
        EObject lv_conditions_15_0 = null;

        EObject lv_audios_16_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:802:28: ( ( ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_conditions_15_0= ruleCondition ) )? ( (lv_audios_16_0= ruleAudios ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:1: ( ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_conditions_15_0= ruleCondition ) )? ( (lv_audios_16_0= ruleAudios ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:1: ( ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_conditions_15_0= ruleCondition ) )? ( (lv_audios_16_0= ruleAudios ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:2: ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) ( (lv_conditions_15_0= ruleCondition ) )? ( (lv_audios_16_0= ruleAudios ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:2: ( (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt10=1;
                }
                break;
            case 18:
                {
                alt10=2;
                }
                break;
            case 19:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:3: (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:3: (otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:803:5: otherlv_0= 'blindTransfer' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleTransferDsl1785); 

                        	newLeafNode(otherlv_0, grammarAccess.getTransferDslAccess().getBlindTransferKeyword_0_0_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:807:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:808:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:808:1: (lv_name_1_0= RULE_ID )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:809:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransferDsl1802); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getTransferDslAccess().getNameIDTerminalRuleCall_0_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransferDslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:826:6: (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:826:6: (otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:826:8: otherlv_2= 'consultationTransfer' ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTransferDsl1827); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransferDslAccess().getConsultationTransferKeyword_0_1_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:830:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:831:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:831:1: (lv_name_3_0= RULE_ID )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:832:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransferDsl1844); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getTransferDslAccess().getNameIDTerminalRuleCall_0_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransferDslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:849:6: (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:849:6: (otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:849:8: otherlv_4= 'bridgeTransfer' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTransferDsl1869); 

                        	newLeafNode(otherlv_4, grammarAccess.getTransferDslAccess().getBridgeTransferKeyword_0_2_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:853:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:854:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:854:1: (lv_name_5_0= RULE_ID )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:855:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransferDsl1886); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getTransferDslAccess().getNameIDTerminalRuleCall_0_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransferDslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:871:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:873:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:873:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:874:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:877:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:878:3: ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:878:3: ( ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=5;
                int LA11_0 = input.LA(1);

                if ( LA11_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 1) ) {
                    alt11=2;
                }
                else if ( LA11_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 2) ) {
                    alt11=3;
                }
                else if ( LA11_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 3) ) {
                    alt11=4;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:880:4: ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:880:4: ({...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:881:5: {...}? => ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:881:108: ( ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:882:6: ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:885:6: ({...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:885:7: {...}? => (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:885:16: (otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:885:18: otherlv_7= 'destination' ( (lv_destination_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleTransferDsl1951); 

            	        	newLeafNode(otherlv_7, grammarAccess.getTransferDslAccess().getDestinationKeyword_1_0_0());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:889:1: ( (lv_destination_8_0= RULE_STRING ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:890:1: (lv_destination_8_0= RULE_STRING )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:890:1: (lv_destination_8_0= RULE_STRING )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:891:3: lv_destination_8_0= RULE_STRING
            	    {
            	    lv_destination_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTransferDsl1968); 

            	    			newLeafNode(lv_destination_8_0, grammarAccess.getTransferDslAccess().getDestinationSTRINGTerminalRuleCall_1_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransferDslRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"destination",
            	            		lv_destination_8_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:914:4: ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:914:4: ({...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:915:5: {...}? => ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:915:108: ( ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:916:6: ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:919:6: ({...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:919:7: {...}? => (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:919:16: (otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:919:18: otherlv_9= 'audioTransfer' ( (lv_audioTransfer_10_0= RULE_STRING ) )
            	    {
            	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTransferDsl2041); 

            	        	newLeafNode(otherlv_9, grammarAccess.getTransferDslAccess().getAudioTransferKeyword_1_1_0());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:923:1: ( (lv_audioTransfer_10_0= RULE_STRING ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:924:1: (lv_audioTransfer_10_0= RULE_STRING )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:924:1: (lv_audioTransfer_10_0= RULE_STRING )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:925:3: lv_audioTransfer_10_0= RULE_STRING
            	    {
            	    lv_audioTransfer_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTransferDsl2058); 

            	    			newLeafNode(lv_audioTransfer_10_0, grammarAccess.getTransferDslAccess().getAudioTransferSTRINGTerminalRuleCall_1_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransferDslRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"audioTransfer",
            	            		lv_audioTransfer_10_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:948:4: ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:948:4: ({...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:949:5: {...}? => ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:949:108: ( ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:950:6: ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:953:6: ({...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:953:7: {...}? => (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:953:16: (otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:953:18: otherlv_11= 'maxTime' ( (lv_maxTime_12_0= RULE_STRING ) )
            	    {
            	    otherlv_11=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTransferDsl2131); 

            	        	newLeafNode(otherlv_11, grammarAccess.getTransferDslAccess().getMaxTimeKeyword_1_2_0());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:957:1: ( (lv_maxTime_12_0= RULE_STRING ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:958:1: (lv_maxTime_12_0= RULE_STRING )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:958:1: (lv_maxTime_12_0= RULE_STRING )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:959:3: lv_maxTime_12_0= RULE_STRING
            	    {
            	    lv_maxTime_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTransferDsl2148); 

            	    			newLeafNode(lv_maxTime_12_0, grammarAccess.getTransferDslAccess().getMaxTimeSTRINGTerminalRuleCall_1_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransferDslRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"maxTime",
            	            		lv_maxTime_12_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:982:4: ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:982:4: ({...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:983:5: {...}? => ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:983:108: ( ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:984:6: ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTransferDslAccess().getUnorderedGroup_1(), 3);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:987:6: ({...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:987:7: {...}? => (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransferDsl", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:987:16: (otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:987:18: otherlv_13= 'timeout' ( (lv_timeout_14_0= RULE_STRING ) )
            	    {
            	    otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTransferDsl2221); 

            	        	newLeafNode(otherlv_13, grammarAccess.getTransferDslAccess().getTimeoutKeyword_1_3_0());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:991:1: ( (lv_timeout_14_0= RULE_STRING ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:992:1: (lv_timeout_14_0= RULE_STRING )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:992:1: (lv_timeout_14_0= RULE_STRING )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:993:3: lv_timeout_14_0= RULE_STRING
            	    {
            	    lv_timeout_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTransferDsl2238); 

            	    			newLeafNode(lv_timeout_14_0, grammarAccess.getTransferDslAccess().getTimeoutSTRINGTerminalRuleCall_1_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransferDslRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"timeout",
            	            		lv_timeout_14_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTransferDslAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleTransferDsl", "getUnorderedGroupHelper().canLeave(grammarAccess.getTransferDslAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getTransferDslAccess().getUnorderedGroup_1());
            	

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1024:2: ( (lv_conditions_15_0= ruleCondition ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==41) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1025:1: (lv_conditions_15_0= ruleCondition )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1025:1: (lv_conditions_15_0= ruleCondition )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1026:3: lv_conditions_15_0= ruleCondition
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransferDslAccess().getConditionsConditionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCondition_in_ruleTransferDsl2311);
                    lv_conditions_15_0=ruleCondition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransferDslRule());
                    	        }
                           		add(
                           			current, 
                           			"conditions",
                            		lv_conditions_15_0, 
                            		"Condition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1042:3: ( (lv_audios_16_0= ruleAudios ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1043:1: (lv_audios_16_0= ruleAudios )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1043:1: (lv_audios_16_0= ruleAudios )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1044:3: lv_audios_16_0= ruleAudios
            {
             
            	        newCompositeNode(grammarAccess.getTransferDslAccess().getAudiosAudiosParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_ruleTransferDsl2333);
            lv_audios_16_0=ruleAudios();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransferDslRule());
            	        }
                   		set(
                   			current, 
                   			"audios",
                    		lv_audios_16_0, 
                    		"Audios");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransferDsl"


    // $ANTLR start "entryRuleGrammars"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1068:1: entryRuleGrammars returns [EObject current=null] : iv_ruleGrammars= ruleGrammars EOF ;
    public final EObject entryRuleGrammars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammars = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1069:2: (iv_ruleGrammars= ruleGrammars EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1070:2: iv_ruleGrammars= ruleGrammars EOF
            {
             newCompositeNode(grammarAccess.getGrammarsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammars_in_entryRuleGrammars2369);
            iv_ruleGrammars=ruleGrammars();

            state._fsp--;

             current =iv_ruleGrammars; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammars2379); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammars"


    // $ANTLR start "ruleGrammars"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1077:1: ruleGrammars returns [EObject current=null] : ( () otherlv_1= 'grammars' otherlv_2= '{' ( (lv_grammatics_3_0= ruleGrammar ) )* otherlv_4= '}' ) ;
    public final EObject ruleGrammars() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_grammatics_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1080:28: ( ( () otherlv_1= 'grammars' otherlv_2= '{' ( (lv_grammatics_3_0= ruleGrammar ) )* otherlv_4= '}' ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1081:1: ( () otherlv_1= 'grammars' otherlv_2= '{' ( (lv_grammatics_3_0= ruleGrammar ) )* otherlv_4= '}' )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1081:1: ( () otherlv_1= 'grammars' otherlv_2= '{' ( (lv_grammatics_3_0= ruleGrammar ) )* otherlv_4= '}' )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1081:2: () otherlv_1= 'grammars' otherlv_2= '{' ( (lv_grammatics_3_0= ruleGrammar ) )* otherlv_4= '}'
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1081:2: ()
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1082:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGrammarsAccess().getGrammarsAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleGrammars2425); 

                	newLeafNode(otherlv_1, grammarAccess.getGrammarsAccess().getGrammarsKeyword_1());
                
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleGrammars2437); 

                	newLeafNode(otherlv_2, grammarAccess.getGrammarsAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1095:1: ( (lv_grammatics_3_0= ruleGrammar ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=37 && LA13_0<=39)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1096:1: (lv_grammatics_3_0= ruleGrammar )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1096:1: (lv_grammatics_3_0= ruleGrammar )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1097:3: lv_grammatics_3_0= ruleGrammar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGrammarsAccess().getGrammaticsGrammarParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_ruleGrammars2458);
            	    lv_grammatics_3_0=ruleGrammar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGrammarsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"grammatics",
            	            		lv_grammatics_3_0, 
            	            		"Grammar");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_4=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleGrammars2471); 

                	newLeafNode(otherlv_4, grammarAccess.getGrammarsAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammars"


    // $ANTLR start "entryRuleAudios"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1125:1: entryRuleAudios returns [EObject current=null] : iv_ruleAudios= ruleAudios EOF ;
    public final EObject entryRuleAudios() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAudios = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1126:2: (iv_ruleAudios= ruleAudios EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1127:2: iv_ruleAudios= ruleAudios EOF
            {
             newCompositeNode(grammarAccess.getAudiosRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAudios_in_entryRuleAudios2507);
            iv_ruleAudios=ruleAudios();

            state._fsp--;

             current =iv_ruleAudios; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAudios2517); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAudios"


    // $ANTLR start "ruleAudios"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1134:1: ruleAudios returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleAudios() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_mainAudios_5_0 = null;

        EObject lv_matchAudios_8_0 = null;

        EObject lv_noMatchAudios_11_0 = null;

        EObject lv_noInputAudios_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1137:28: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1138:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1138:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1140:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1140:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1141:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1144:2: ( ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?)
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1145:3: ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+ {...}?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1145:3: ( ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=6;
                int LA19_0 = input.LA(1);

                if ( LA19_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 0) ) {
                    alt19=1;
                }
                else if ( LA19_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 1) ) {
                    alt19=2;
                }
                else if ( LA19_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 2) ) {
                    alt19=3;
                }
                else if ( LA19_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 3) ) {
                    alt19=4;
                }
                else if ( LA19_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 4) ) {
                    alt19=5;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1147:4: ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1147:4: ({...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1148:5: {...}? => ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1148:101: ( ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1149:6: ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAudiosAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1152:6: ({...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1152:7: {...}? => (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1152:16: (otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )? )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1152:18: otherlv_1= 'audios' otherlv_2= '{' (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )?
            	    {
            	    otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleAudios2599); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0());
            	        
            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAudios2611); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1160:1: (otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+ )?
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==28) ) {
            	        alt15=1;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1160:3: otherlv_3= 'main' otherlv_4= ':' ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+
            	            {
            	            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAudios2624); 

            	                	newLeafNode(otherlv_3, grammarAccess.getAudiosAccess().getMainKeyword_0_2_0());
            	                
            	            otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAudios2636); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAudiosAccess().getColonKeyword_0_2_1());
            	                
            	            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1168:1: ( (lv_mainAudios_5_0= ruleConditionalAudio ) )+
            	            int cnt14=0;
            	            loop14:
            	            do {
            	                int alt14=2;
            	                int LA14_0 = input.LA(1);

            	                if ( (LA14_0==45||LA14_0==51) ) {
            	                    alt14=1;
            	                }


            	                switch (alt14) {
            	            	case 1 :
            	            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1169:1: (lv_mainAudios_5_0= ruleConditionalAudio )
            	            	    {
            	            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1169:1: (lv_mainAudios_5_0= ruleConditionalAudio )
            	            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1170:3: lv_mainAudios_5_0= ruleConditionalAudio
            	            	    {
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAudiosAccess().getMainAudiosConditionalAudioParserRuleCall_0_2_2_0()); 
            	            	    	    
            	            	    pushFollow(FollowSets000.FOLLOW_ruleConditionalAudio_in_ruleAudios2657);
            	            	    lv_mainAudios_5_0=ruleConditionalAudio();

            	            	    state._fsp--;


            	            	    	        if (current==null) {
            	            	    	            current = createModelElementForParent(grammarAccess.getAudiosRule());
            	            	    	        }
            	            	           		add(
            	            	           			current, 
            	            	           			"mainAudios",
            	            	            		lv_mainAudios_5_0, 
            	            	            		"ConditionalAudio");
            	            	    	        afterParserOrEnumRuleCall();
            	            	    	    

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt14 >= 1 ) break loop14;
            	                        EarlyExitException eee =
            	                            new EarlyExitException(14, input);
            	                        throw eee;
            	                }
            	                cnt14++;
            	            } while (true);


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1193:4: ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1193:4: ({...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1194:5: {...}? => ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1194:101: ( ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1195:6: ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAudiosAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1198:6: ({...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1198:7: {...}? => (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1198:16: (otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1198:18: otherlv_6= 'match' otherlv_7= ':' ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+
            	    {
            	    otherlv_6=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleAudios2728); 

            	        	newLeafNode(otherlv_6, grammarAccess.getAudiosAccess().getMatchKeyword_1_0());
            	        
            	    otherlv_7=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAudios2740); 

            	        	newLeafNode(otherlv_7, grammarAccess.getAudiosAccess().getColonKeyword_1_1());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1206:1: ( (lv_matchAudios_8_0= ruleConditionalAudio ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==45||LA16_0==51) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1207:1: (lv_matchAudios_8_0= ruleConditionalAudio )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1207:1: (lv_matchAudios_8_0= ruleConditionalAudio )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1208:3: lv_matchAudios_8_0= ruleConditionalAudio
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAudiosAccess().getMatchAudiosConditionalAudioParserRuleCall_1_2_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleConditionalAudio_in_ruleAudios2761);
            	    	    lv_matchAudios_8_0=ruleConditionalAudio();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAudiosRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"matchAudios",
            	    	            		lv_matchAudios_8_0, 
            	    	            		"ConditionalAudio");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1231:4: ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1231:4: ({...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1232:5: {...}? => ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1232:101: ( ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1233:6: ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAudiosAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1236:6: ({...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1236:7: {...}? => (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1236:16: (otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1236:18: otherlv_9= 'nomatch' otherlv_10= ':' ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+
            	    {
            	    otherlv_9=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAudios2830); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAudiosAccess().getNomatchKeyword_2_0());
            	        
            	    otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAudios2842); 

            	        	newLeafNode(otherlv_10, grammarAccess.getAudiosAccess().getColonKeyword_2_1());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1244:1: ( (lv_noMatchAudios_11_0= ruleConditionalAudio ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==45||LA17_0==51) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1245:1: (lv_noMatchAudios_11_0= ruleConditionalAudio )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1245:1: (lv_noMatchAudios_11_0= ruleConditionalAudio )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1246:3: lv_noMatchAudios_11_0= ruleConditionalAudio
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAudiosAccess().getNoMatchAudiosConditionalAudioParserRuleCall_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleConditionalAudio_in_ruleAudios2863);
            	    	    lv_noMatchAudios_11_0=ruleConditionalAudio();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAudiosRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"noMatchAudios",
            	    	            		lv_noMatchAudios_11_0, 
            	    	            		"ConditionalAudio");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1269:4: ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1269:4: ({...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1270:5: {...}? => ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 3)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1270:101: ( ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1271:6: ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAudiosAccess().getUnorderedGroup(), 3);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1274:6: ({...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1274:7: {...}? => (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1274:16: (otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+ )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1274:18: otherlv_12= 'noinput' otherlv_13= ':' ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+
            	    {
            	    otherlv_12=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAudios2932); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAudiosAccess().getNoinputKeyword_3_0());
            	        
            	    otherlv_13=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAudios2944); 

            	        	newLeafNode(otherlv_13, grammarAccess.getAudiosAccess().getColonKeyword_3_1());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1282:1: ( (lv_noInputAudios_14_0= ruleConditionalAudio ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==45||LA18_0==51) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1283:1: (lv_noInputAudios_14_0= ruleConditionalAudio )
            	    	    {
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1283:1: (lv_noInputAudios_14_0= ruleConditionalAudio )
            	    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1284:3: lv_noInputAudios_14_0= ruleConditionalAudio
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAudiosAccess().getNoInputAudiosConditionalAudioParserRuleCall_3_2_0()); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleConditionalAudio_in_ruleAudios2965);
            	    	    lv_noInputAudios_14_0=ruleConditionalAudio();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getAudiosRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"noInputAudios",
            	    	            		lv_noInputAudios_14_0, 
            	    	            		"ConditionalAudio");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1307:4: ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1307:4: ({...}? => ( ({...}? => (otherlv_15= '}' ) ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1308:5: {...}? => ( ({...}? => (otherlv_15= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canSelect(grammarAccess.getAudiosAccess().getUnorderedGroup(), 4)");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1308:101: ( ({...}? => (otherlv_15= '}' ) ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1309:6: ({...}? => (otherlv_15= '}' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAudiosAccess().getUnorderedGroup(), 4);
            	    	 				
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1312:6: ({...}? => (otherlv_15= '}' ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1312:7: {...}? => (otherlv_15= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAudios", "true");
            	    }
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1312:16: (otherlv_15= '}' )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1312:18: otherlv_15= '}'
            	    {
            	    otherlv_15=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAudios3034); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4());
            	        

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAudiosAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleAudios", "getUnorderedGroupHelper().canLeave(grammarAccess.getAudiosAccess().getUnorderedGroup())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAudiosAccess().getUnorderedGroup());
            	

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAudios"


    // $ANTLR start "entryRuleConfiguration"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1339:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1340:2: (iv_ruleConfiguration= ruleConfiguration EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1341:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration3116);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration3126); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1348:1: ruleConfiguration returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_configValue_2_0= ruleConfigValue ) )* otherlv_3= '}' ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_configValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1351:28: ( ( () otherlv_1= '{' ( (lv_configValue_2_0= ruleConfigValue ) )* otherlv_3= '}' ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1352:1: ( () otherlv_1= '{' ( (lv_configValue_2_0= ruleConfigValue ) )* otherlv_3= '}' )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1352:1: ( () otherlv_1= '{' ( (lv_configValue_2_0= ruleConfigValue ) )* otherlv_3= '}' )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1352:2: () otherlv_1= '{' ( (lv_configValue_2_0= ruleConfigValue ) )* otherlv_3= '}'
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1352:2: ()
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1353:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleConfiguration3172); 

                	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1362:1: ( (lv_configValue_2_0= ruleConfigValue ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1363:1: (lv_configValue_2_0= ruleConfigValue )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1363:1: (lv_configValue_2_0= ruleConfigValue )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1364:3: lv_configValue_2_0= ruleConfigValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getConfigValueConfigValueParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleConfigValue_in_ruleConfiguration3193);
            	    lv_configValue_2_0=ruleConfigValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configValue",
            	            		lv_configValue_2_0, 
            	            		"ConfigValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConfiguration3206); 

                	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleConfigValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1392:1: entryRuleConfigValue returns [EObject current=null] : iv_ruleConfigValue= ruleConfigValue EOF ;
    public final EObject entryRuleConfigValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfigValue = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1393:2: (iv_ruleConfigValue= ruleConfigValue EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1394:2: iv_ruleConfigValue= ruleConfigValue EOF
            {
             newCompositeNode(grammarAccess.getConfigValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfigValue_in_entryRuleConfigValue3242);
            iv_ruleConfigValue=ruleConfigValue();

            state._fsp--;

             current =iv_ruleConfigValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfigValue3252); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigValue"


    // $ANTLR start "ruleConfigValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1401:1: ruleConfigValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_value_1_0= ruleConfigValueValue ) ) ) ;
    public final EObject ruleConfigValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1404:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_value_1_0= ruleConfigValueValue ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1405:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_value_1_0= ruleConfigValueValue ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1405:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_value_1_0= ruleConfigValueValue ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1405:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_value_1_0= ruleConfigValueValue ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1405:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1406:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1406:1: (lv_name_0_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1407:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConfigValue3294); 

            			newLeafNode(lv_name_0_0, grammarAccess.getConfigValueAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConfigValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1423:2: ( (lv_value_1_0= ruleConfigValueValue ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1424:1: (lv_value_1_0= ruleConfigValueValue )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1424:1: (lv_value_1_0= ruleConfigValueValue )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1425:3: lv_value_1_0= ruleConfigValueValue
            {
             
            	        newCompositeNode(grammarAccess.getConfigValueAccess().getValueConfigValueValueParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConfigValueValue_in_ruleConfigValue3320);
            lv_value_1_0=ruleConfigValueValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConfigValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"ConfigValueValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfigValue"


    // $ANTLR start "entryRuleConfigValueValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1449:1: entryRuleConfigValueValue returns [String current=null] : iv_ruleConfigValueValue= ruleConfigValueValue EOF ;
    public final String entryRuleConfigValueValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConfigValueValue = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1450:2: (iv_ruleConfigValueValue= ruleConfigValueValue EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1451:2: iv_ruleConfigValueValue= ruleConfigValueValue EOF
            {
             newCompositeNode(grammarAccess.getConfigValueValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfigValueValue_in_entryRuleConfigValueValue3357);
            iv_ruleConfigValueValue=ruleConfigValueValue();

            state._fsp--;

             current =iv_ruleConfigValueValue.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfigValueValue3368); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigValueValue"


    // $ANTLR start "ruleConfigValueValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1458:1: ruleConfigValueValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? ) | this_FLOAT_3= RULE_FLOAT | kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleConfigValueValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_FLOAT_3=null;

         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1461:28: ( ( (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? ) | this_FLOAT_3= RULE_FLOAT | kw= 'true' | kw= 'false' ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1462:1: ( (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? ) | this_FLOAT_3= RULE_FLOAT | kw= 'true' | kw= 'false' )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1462:1: ( (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? ) | this_FLOAT_3= RULE_FLOAT | kw= 'true' | kw= 'false' )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt22=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt22=2;
                }
                break;
            case 35:
                {
                alt22=3;
                }
                break;
            case 36:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1462:2: (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1462:2: (this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )? )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1462:7: this_INT_0= RULE_INT (kw= 'ms' | kw= 's' )?
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConfigValueValue3409); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getConfigValueValueAccess().getINTTerminalRuleCall_0_0()); 
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1469:1: (kw= 'ms' | kw= 's' )?
                    int alt21=3;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==33) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==34) ) {
                        alt21=2;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1470:2: kw= 'ms'
                            {
                            kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleConfigValueValue3428); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getConfigValueValueAccess().getMsKeyword_0_1_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1477:2: kw= 's'
                            {
                            kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleConfigValueValue3447); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getConfigValueValueAccess().getSKeyword_0_1_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1483:10: this_FLOAT_3= RULE_FLOAT
                    {
                    this_FLOAT_3=(Token)match(input,RULE_FLOAT,FollowSets000.FOLLOW_RULE_FLOAT_in_ruleConfigValueValue3471); 

                    		current.merge(this_FLOAT_3);
                        
                     
                        newLeafNode(this_FLOAT_3, grammarAccess.getConfigValueValueAccess().getFLOATTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1492:2: kw= 'true'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleConfigValueValue3495); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConfigValueValueAccess().getTrueKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1499:2: kw= 'false'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleConfigValueValue3514); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConfigValueValueAccess().getFalseKeyword_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfigValueValue"


    // $ANTLR start "entryRuleGrammar"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1512:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1513:2: (iv_ruleGrammar= ruleGrammar EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1514:2: iv_ruleGrammar= ruleGrammar EOF
            {
             newCompositeNode(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGrammar_in_entryRuleGrammar3554);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammar3564); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1521:1: ruleGrammar returns [EObject current=null] : ( ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) ) ( (lv_expr_1_0= 'expr' ) )? ( (lv_src_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_mode_0_1=null;
        Token lv_mode_0_2=null;
        Token lv_mode_0_3=null;
        Token lv_expr_1_0=null;
        Token lv_src_2_0=null;

         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1524:28: ( ( ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) ) ( (lv_expr_1_0= 'expr' ) )? ( (lv_src_2_0= RULE_STRING ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1525:1: ( ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) ) ( (lv_expr_1_0= 'expr' ) )? ( (lv_src_2_0= RULE_STRING ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1525:1: ( ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) ) ( (lv_expr_1_0= 'expr' ) )? ( (lv_src_2_0= RULE_STRING ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1525:2: ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) ) ( (lv_expr_1_0= 'expr' ) )? ( (lv_src_2_0= RULE_STRING ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1525:2: ( ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1526:1: ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1526:1: ( (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1527:1: (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1527:1: (lv_mode_0_1= 'voice' | lv_mode_0_2= 'dtmf' | lv_mode_0_3= 'voicedtmf' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt23=1;
                }
                break;
            case 38:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1528:3: lv_mode_0_1= 'voice'
                    {
                    lv_mode_0_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleGrammar3609); 

                            newLeafNode(lv_mode_0_1, grammarAccess.getGrammarAccess().getModeVoiceKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                           		setWithLastConsumed(current, "mode", lv_mode_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1540:8: lv_mode_0_2= 'dtmf'
                    {
                    lv_mode_0_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleGrammar3638); 

                            newLeafNode(lv_mode_0_2, grammarAccess.getGrammarAccess().getModeDtmfKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                           		setWithLastConsumed(current, "mode", lv_mode_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1552:8: lv_mode_0_3= 'voicedtmf'
                    {
                    lv_mode_0_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleGrammar3667); 

                            newLeafNode(lv_mode_0_3, grammarAccess.getGrammarAccess().getModeVoicedtmfKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                           		setWithLastConsumed(current, "mode", lv_mode_0_3, null);
                    	    

                    }
                    break;

            }


            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1567:2: ( (lv_expr_1_0= 'expr' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1568:1: (lv_expr_1_0= 'expr' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1568:1: (lv_expr_1_0= 'expr' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1569:3: lv_expr_1_0= 'expr'
                    {
                    lv_expr_1_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleGrammar3701); 

                            newLeafNode(lv_expr_1_0, grammarAccess.getGrammarAccess().getExprExprKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getGrammarRule());
                    	        }
                           		setWithLastConsumed(current, "expr", true, "expr");
                    	    

                    }


                    }
                    break;

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1582:3: ( (lv_src_2_0= RULE_STRING ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1583:1: (lv_src_2_0= RULE_STRING )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1583:1: (lv_src_2_0= RULE_STRING )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1584:3: lv_src_2_0= RULE_STRING
            {
            lv_src_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGrammar3732); 

            			newLeafNode(lv_src_2_0, grammarAccess.getGrammarAccess().getSrcSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGrammarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"src",
                    		lv_src_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleCondition"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1608:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1609:2: (iv_ruleCondition= ruleCondition EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1610:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCondition_in_entryRuleCondition3773);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCondition3783); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1617:1: ruleCondition returns [EObject current=null] : ( () otherlv_1= 'condition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_condition_3_0= RULE_INT ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_condition_3_0=null;

         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1620:28: ( ( () otherlv_1= 'condition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_condition_3_0= RULE_INT ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1621:1: ( () otherlv_1= 'condition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_condition_3_0= RULE_INT ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1621:1: ( () otherlv_1= 'condition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_condition_3_0= RULE_INT ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1621:2: () otherlv_1= 'condition' ( (lv_name_2_0= RULE_ID ) ) ( (lv_condition_3_0= RULE_INT ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1621:2: ()
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1622:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConditionAccess().getConditionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleCondition3829); 

                	newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getConditionKeyword_1());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1631:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1632:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1632:1: (lv_name_2_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1633:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCondition3846); 

            			newLeafNode(lv_name_2_0, grammarAccess.getConditionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConditionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1649:2: ( (lv_condition_3_0= RULE_INT ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1650:1: (lv_condition_3_0= RULE_INT )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1650:1: (lv_condition_3_0= RULE_INT )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1651:3: lv_condition_3_0= RULE_INT
            {
            lv_condition_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCondition3868); 

            			newLeafNode(lv_condition_3_0, grammarAccess.getConditionAccess().getConditionINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConditionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"condition",
                    		lv_condition_3_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleOutputs"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1675:1: entryRuleOutputs returns [EObject current=null] : iv_ruleOutputs= ruleOutputs EOF ;
    public final EObject entryRuleOutputs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputs = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1676:2: (iv_ruleOutputs= ruleOutputs EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1677:2: iv_ruleOutputs= ruleOutputs EOF
            {
             newCompositeNode(grammarAccess.getOutputsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOutputs_in_entryRuleOutputs3909);
            iv_ruleOutputs=ruleOutputs();

            state._fsp--;

             current =iv_ruleOutputs; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOutputs3919); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputs"


    // $ANTLR start "ruleOutputs"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1684:1: ruleOutputs returns [EObject current=null] : (otherlv_0= 'options' otherlv_1= '{' ( (lv_output_2_0= ruleOutput ) )+ otherlv_3= '}' ) ;
    public final EObject ruleOutputs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_output_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1687:28: ( (otherlv_0= 'options' otherlv_1= '{' ( (lv_output_2_0= ruleOutput ) )+ otherlv_3= '}' ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1688:1: (otherlv_0= 'options' otherlv_1= '{' ( (lv_output_2_0= ruleOutput ) )+ otherlv_3= '}' )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1688:1: (otherlv_0= 'options' otherlv_1= '{' ( (lv_output_2_0= ruleOutput ) )+ otherlv_3= '}' )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1688:3: otherlv_0= 'options' otherlv_1= '{' ( (lv_output_2_0= ruleOutput ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleOutputs3956); 

                	newLeafNode(otherlv_0, grammarAccess.getOutputsAccess().getOptionsKeyword_0());
                
            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleOutputs3968); 

                	newLeafNode(otherlv_1, grammarAccess.getOutputsAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1696:1: ( (lv_output_2_0= ruleOutput ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1697:1: (lv_output_2_0= ruleOutput )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1697:1: (lv_output_2_0= ruleOutput )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1698:3: lv_output_2_0= ruleOutput
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputsAccess().getOutputOutputParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOutput_in_ruleOutputs3989);
            	    lv_output_2_0=ruleOutput();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"output",
            	            		lv_output_2_0, 
            	            		"Output");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOutputs4002); 

                	newLeafNode(otherlv_3, grammarAccess.getOutputsAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputs"


    // $ANTLR start "entryRuleOutput"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1726:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1727:2: (iv_ruleOutput= ruleOutput EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1728:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOutput_in_entryRuleOutput4038);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOutput4048); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1735:1: ruleOutput returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_outputValue_2_0= ruleOutputValue ) ) (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )* ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_outputValue_2_0 = null;

        EObject lv_outputValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1738:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_outputValue_2_0= ruleOutputValue ) ) (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )* ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1739:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_outputValue_2_0= ruleOutputValue ) ) (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )* )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1739:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_outputValue_2_0= ruleOutputValue ) ) (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )* )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1739:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_outputValue_2_0= ruleOutputValue ) ) (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )*
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1739:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1740:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1740:1: (lv_name_0_0= RULE_ID )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1741:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOutput4090); 

            			newLeafNode(lv_name_0_0, grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOutputRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleOutput4107); 

                	newLeafNode(otherlv_1, grammarAccess.getOutputAccess().getColonKeyword_1());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1761:1: ( (lv_outputValue_2_0= ruleOutputValue ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1762:1: (lv_outputValue_2_0= ruleOutputValue )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1762:1: (lv_outputValue_2_0= ruleOutputValue )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1763:3: lv_outputValue_2_0= ruleOutputValue
            {
             
            	        newCompositeNode(grammarAccess.getOutputAccess().getOutputValueOutputValueParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOutputValue_in_ruleOutput4128);
            lv_outputValue_2_0=ruleOutputValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOutputRule());
            	        }
                   		add(
                   			current, 
                   			"outputValue",
                    		lv_outputValue_2_0, 
                    		"OutputValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1779:2: (otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1779:4: otherlv_3= ',' ( (lv_outputValue_4_0= ruleOutputValue ) )
            	    {
            	    otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleOutput4141); 

            	        	newLeafNode(otherlv_3, grammarAccess.getOutputAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1783:1: ( (lv_outputValue_4_0= ruleOutputValue ) )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1784:1: (lv_outputValue_4_0= ruleOutputValue )
            	    {
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1784:1: (lv_outputValue_4_0= ruleOutputValue )
            	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1785:3: lv_outputValue_4_0= ruleOutputValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputAccess().getOutputValueOutputValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOutputValue_in_ruleOutput4162);
            	    lv_outputValue_4_0=ruleOutputValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"outputValue",
            	            		lv_outputValue_4_0, 
            	            		"OutputValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleOutputValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1809:1: entryRuleOutputValue returns [EObject current=null] : iv_ruleOutputValue= ruleOutputValue EOF ;
    public final EObject entryRuleOutputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputValue = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1810:2: (iv_ruleOutputValue= ruleOutputValue EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1811:2: iv_ruleOutputValue= ruleOutputValue EOF
            {
             newCompositeNode(grammarAccess.getOutputValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOutputValue_in_entryRuleOutputValue4200);
            iv_ruleOutputValue=ruleOutputValue();

            state._fsp--;

             current =iv_ruleOutputValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOutputValue4210); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputValue"


    // $ANTLR start "ruleOutputValue"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1818:1: ruleOutputValue returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= '*' ) ) ) ;
    public final EObject ruleOutputValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1821:28: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= '*' ) ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1822:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= '*' ) ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1822:1: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_value_1_0= '*' ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING) ) {
                alt27=1;
            }
            else if ( (LA27_0==44) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1822:2: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1822:2: ( (lv_value_0_0= RULE_STRING ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1823:1: (lv_value_0_0= RULE_STRING )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1823:1: (lv_value_0_0= RULE_STRING )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1824:3: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleOutputValue4252); 

                    			newLeafNode(lv_value_0_0, grammarAccess.getOutputValueAccess().getValueSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_0_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1841:6: ( (lv_value_1_0= '*' ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1841:6: ( (lv_value_1_0= '*' ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1842:1: (lv_value_1_0= '*' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1842:1: (lv_value_1_0= '*' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1843:3: lv_value_1_0= '*'
                    {
                    lv_value_1_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleOutputValue4281); 

                            newLeafNode(lv_value_1_0, grammarAccess.getOutputValueAccess().getValueAsteriskKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputValueRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_1_0, "*");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputValue"


    // $ANTLR start "entryRuleSimpleAudio"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1864:1: entryRuleSimpleAudio returns [EObject current=null] : iv_ruleSimpleAudio= ruleSimpleAudio EOF ;
    public final EObject entryRuleSimpleAudio() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAudio = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1865:2: (iv_ruleSimpleAudio= ruleSimpleAudio EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1866:2: iv_ruleSimpleAudio= ruleSimpleAudio EOF
            {
             newCompositeNode(grammarAccess.getSimpleAudioRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAudio_in_entryRuleSimpleAudio4330);
            iv_ruleSimpleAudio=ruleSimpleAudio();

            state._fsp--;

             current =iv_ruleSimpleAudio; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAudio4340); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAudio"


    // $ANTLR start "ruleSimpleAudio"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1873:1: ruleSimpleAudio returns [EObject current=null] : ( () otherlv_1= 'say' ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? ) ) ;
    public final EObject ruleSimpleAudio() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_src_3_0=null;
        Token otherlv_4=null;
        Token lv_tts_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_format_9_0=null;
        Token otherlv_10=null;
        Token lv_tts_11_0=null;
        Enumerator lv_interpretation_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1876:28: ( ( () otherlv_1= 'say' ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1877:1: ( () otherlv_1= 'say' ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1877:1: ( () otherlv_1= 'say' ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1877:2: () otherlv_1= 'say' ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1877:2: ()
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1878:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleAudioAccess().getAudioAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleSimpleAudio4386); 

                	newLeafNode(otherlv_1, grammarAccess.getSimpleAudioAccess().getSayKeyword_1());
                
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1887:1: ( (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )? )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1887:2: (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )?
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1887:2: (otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==46) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1887:4: otherlv_2= 'src' ( (lv_src_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSimpleAudio4400); 

                        	newLeafNode(otherlv_2, grammarAccess.getSimpleAudioAccess().getSrcKeyword_2_0_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1891:1: ( (lv_src_3_0= RULE_STRING ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1892:1: (lv_src_3_0= RULE_STRING )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1892:1: (lv_src_3_0= RULE_STRING )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1893:3: lv_src_3_0= RULE_STRING
                    {
                    lv_src_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleAudio4417); 

                    			newLeafNode(lv_src_3_0, grammarAccess.getSimpleAudioAccess().getSrcSTRINGTerminalRuleCall_2_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAudioRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"src",
                            		lv_src_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1909:4: ( (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) ) | (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) ) )?
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            else if ( (LA30_0==48) ) {
                alt30=2;
            }
            switch (alt30) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1909:5: (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1909:5: (otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1909:7: otherlv_4= 'wording' ( (lv_tts_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSimpleAudio4438); 

                        	newLeafNode(otherlv_4, grammarAccess.getSimpleAudioAccess().getWordingKeyword_2_1_0_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1913:1: ( (lv_tts_5_0= RULE_STRING ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1914:1: (lv_tts_5_0= RULE_STRING )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1914:1: (lv_tts_5_0= RULE_STRING )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1915:3: lv_tts_5_0= RULE_STRING
                    {
                    lv_tts_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleAudio4455); 

                    			newLeafNode(lv_tts_5_0, grammarAccess.getSimpleAudioAccess().getTtsSTRINGTerminalRuleCall_2_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAudioRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"tts",
                            		lv_tts_5_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1932:6: (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1932:6: (otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1932:8: otherlv_6= 'as' ( (lv_interpretation_7_0= ruleInterpretation ) ) (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )? ( (lv_tts_11_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleSimpleAudio4480); 

                        	newLeafNode(otherlv_6, grammarAccess.getSimpleAudioAccess().getAsKeyword_2_1_1_0());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1936:1: ( (lv_interpretation_7_0= ruleInterpretation ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1937:1: (lv_interpretation_7_0= ruleInterpretation )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1937:1: (lv_interpretation_7_0= ruleInterpretation )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1938:3: lv_interpretation_7_0= ruleInterpretation
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleAudioAccess().getInterpretationInterpretationEnumRuleCall_2_1_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInterpretation_in_ruleSimpleAudio4501);
                    lv_interpretation_7_0=ruleInterpretation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleAudioRule());
                    	        }
                           		set(
                           			current, 
                           			"interpretation",
                            		lv_interpretation_7_0, 
                            		"Interpretation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1954:2: (otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==49) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1954:4: otherlv_8= '(' ( (lv_format_9_0= RULE_STRING ) ) otherlv_10= ')'
                            {
                            otherlv_8=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleSimpleAudio4514); 

                                	newLeafNode(otherlv_8, grammarAccess.getSimpleAudioAccess().getLeftParenthesisKeyword_2_1_1_2_0());
                                
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1958:1: ( (lv_format_9_0= RULE_STRING ) )
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1959:1: (lv_format_9_0= RULE_STRING )
                            {
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1959:1: (lv_format_9_0= RULE_STRING )
                            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1960:3: lv_format_9_0= RULE_STRING
                            {
                            lv_format_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleAudio4531); 

                            			newLeafNode(lv_format_9_0, grammarAccess.getSimpleAudioAccess().getFormatSTRINGTerminalRuleCall_2_1_1_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSimpleAudioRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"format",
                                    		lv_format_9_0, 
                                    		"STRING");
                            	    

                            }


                            }

                            otherlv_10=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleSimpleAudio4548); 

                                	newLeafNode(otherlv_10, grammarAccess.getSimpleAudioAccess().getRightParenthesisKeyword_2_1_1_2_2());
                                

                            }
                            break;

                    }

                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1980:3: ( (lv_tts_11_0= RULE_STRING ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1981:1: (lv_tts_11_0= RULE_STRING )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1981:1: (lv_tts_11_0= RULE_STRING )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:1982:3: lv_tts_11_0= RULE_STRING
                    {
                    lv_tts_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleAudio4567); 

                    			newLeafNode(lv_tts_11_0, grammarAccess.getSimpleAudioAccess().getTtsSTRINGTerminalRuleCall_2_1_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleAudioRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"tts",
                            		lv_tts_11_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAudio"


    // $ANTLR start "entryRuleConditionalAudio"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2006:1: entryRuleConditionalAudio returns [EObject current=null] : iv_ruleConditionalAudio= ruleConditionalAudio EOF ;
    public final EObject entryRuleConditionalAudio() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalAudio = null;


        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2007:2: (iv_ruleConditionalAudio= ruleConditionalAudio EOF )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2008:2: iv_ruleConditionalAudio= ruleConditionalAudio EOF
            {
             newCompositeNode(grammarAccess.getConditionalAudioRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConditionalAudio_in_entryRuleConditionalAudio4612);
            iv_ruleConditionalAudio=ruleConditionalAudio();

            state._fsp--;

             current =iv_ruleConditionalAudio; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConditionalAudio4622); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalAudio"


    // $ANTLR start "ruleConditionalAudio"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2015:1: ruleConditionalAudio returns [EObject current=null] : ( ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' ) | this_SimpleAudio_8= ruleSimpleAudio ) ;
    public final EObject ruleConditionalAudio() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_condit_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_simpleAudios_6_0 = null;

        EObject this_SimpleAudio_8 = null;


         enterRule(); 
            
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2018:28: ( ( ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' ) | this_SimpleAudio_8= ruleSimpleAudio ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:1: ( ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' ) | this_SimpleAudio_8= ruleSimpleAudio )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:1: ( ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' ) | this_SimpleAudio_8= ruleSimpleAudio )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==51) ) {
                alt32=1;
            }
            else if ( (LA32_0==45) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:2: ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:2: ( () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:3: () otherlv_1= 'when' otherlv_2= '(' ( (lv_condit_3_0= RULE_STRING ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+ otherlv_7= '}'
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2019:3: ()
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2020:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getConditionalAudioAccess().getConditionalAudioAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleConditionalAudio4669); 

                        	newLeafNode(otherlv_1, grammarAccess.getConditionalAudioAccess().getWhenKeyword_0_1());
                        
                    otherlv_2=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleConditionalAudio4681); 

                        	newLeafNode(otherlv_2, grammarAccess.getConditionalAudioAccess().getLeftParenthesisKeyword_0_2());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2033:1: ( (lv_condit_3_0= RULE_STRING ) )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2034:1: (lv_condit_3_0= RULE_STRING )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2034:1: (lv_condit_3_0= RULE_STRING )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2035:3: lv_condit_3_0= RULE_STRING
                    {
                    lv_condit_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConditionalAudio4698); 

                    			newLeafNode(lv_condit_3_0, grammarAccess.getConditionalAudioAccess().getConditSTRINGTerminalRuleCall_0_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConditionalAudioRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"condit",
                            		lv_condit_3_0, 
                            		"STRING");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleConditionalAudio4715); 

                        	newLeafNode(otherlv_4, grammarAccess.getConditionalAudioAccess().getRightParenthesisKeyword_0_4());
                        
                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleConditionalAudio4727); 

                        	newLeafNode(otherlv_5, grammarAccess.getConditionalAudioAccess().getLeftCurlyBracketKeyword_0_5());
                        
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2059:1: ( (lv_simpleAudios_6_0= ruleSimpleAudio ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==45) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2060:1: (lv_simpleAudios_6_0= ruleSimpleAudio )
                    	    {
                    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2060:1: (lv_simpleAudios_6_0= ruleSimpleAudio )
                    	    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2061:3: lv_simpleAudios_6_0= ruleSimpleAudio
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConditionalAudioAccess().getSimpleAudiosSimpleAudioParserRuleCall_0_6_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleAudio_in_ruleConditionalAudio4748);
                    	    lv_simpleAudios_6_0=ruleSimpleAudio();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConditionalAudioRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"simpleAudios",
                    	            		lv_simpleAudios_6_0, 
                    	            		"SimpleAudio");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleConditionalAudio4761); 

                        	newLeafNode(otherlv_7, grammarAccess.getConditionalAudioAccess().getRightCurlyBracketKeyword_0_7());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2083:5: this_SimpleAudio_8= ruleSimpleAudio
                    {
                     
                            newCompositeNode(grammarAccess.getConditionalAudioAccess().getSimpleAudioParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleAudio_in_ruleConditionalAudio4790);
                    this_SimpleAudio_8=ruleSimpleAudio();

                    state._fsp--;

                     
                            current = this_SimpleAudio_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalAudio"


    // $ANTLR start "ruleInterpretation"
    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2099:1: ruleInterpretation returns [Enumerator current=null] : ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'boolean' ) | (enumLiteral_2= 'currency' ) | (enumLiteral_3= 'date' ) | (enumLiteral_4= 'digits' ) | (enumLiteral_5= 'phone' ) | (enumLiteral_6= 'time' ) ) ;
    public final Enumerator ruleInterpretation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2101:28: ( ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'boolean' ) | (enumLiteral_2= 'currency' ) | (enumLiteral_3= 'date' ) | (enumLiteral_4= 'digits' ) | (enumLiteral_5= 'phone' ) | (enumLiteral_6= 'time' ) ) )
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2102:1: ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'boolean' ) | (enumLiteral_2= 'currency' ) | (enumLiteral_3= 'date' ) | (enumLiteral_4= 'digits' ) | (enumLiteral_5= 'phone' ) | (enumLiteral_6= 'time' ) )
            {
            // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2102:1: ( (enumLiteral_0= 'number' ) | (enumLiteral_1= 'boolean' ) | (enumLiteral_2= 'currency' ) | (enumLiteral_3= 'date' ) | (enumLiteral_4= 'digits' ) | (enumLiteral_5= 'phone' ) | (enumLiteral_6= 'time' ) )
            int alt33=7;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt33=1;
                }
                break;
            case 53:
                {
                alt33=2;
                }
                break;
            case 54:
                {
                alt33=3;
                }
                break;
            case 55:
                {
                alt33=4;
                }
                break;
            case 56:
                {
                alt33=5;
                }
                break;
            case 57:
                {
                alt33=6;
                }
                break;
            case 58:
                {
                alt33=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2102:2: (enumLiteral_0= 'number' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2102:2: (enumLiteral_0= 'number' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2102:4: enumLiteral_0= 'number'
                    {
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleInterpretation4839); 

                            current = grammarAccess.getInterpretationAccess().getNumberEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getInterpretationAccess().getNumberEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2108:6: (enumLiteral_1= 'boolean' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2108:6: (enumLiteral_1= 'boolean' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2108:8: enumLiteral_1= 'boolean'
                    {
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleInterpretation4856); 

                            current = grammarAccess.getInterpretationAccess().getBooleanEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getInterpretationAccess().getBooleanEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2114:6: (enumLiteral_2= 'currency' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2114:6: (enumLiteral_2= 'currency' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2114:8: enumLiteral_2= 'currency'
                    {
                    enumLiteral_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleInterpretation4873); 

                            current = grammarAccess.getInterpretationAccess().getCurrencyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getInterpretationAccess().getCurrencyEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2120:6: (enumLiteral_3= 'date' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2120:6: (enumLiteral_3= 'date' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2120:8: enumLiteral_3= 'date'
                    {
                    enumLiteral_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleInterpretation4890); 

                            current = grammarAccess.getInterpretationAccess().getDateEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getInterpretationAccess().getDateEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2126:6: (enumLiteral_4= 'digits' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2126:6: (enumLiteral_4= 'digits' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2126:8: enumLiteral_4= 'digits'
                    {
                    enumLiteral_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleInterpretation4907); 

                            current = grammarAccess.getInterpretationAccess().getDigitsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getInterpretationAccess().getDigitsEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2132:6: (enumLiteral_5= 'phone' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2132:6: (enumLiteral_5= 'phone' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2132:8: enumLiteral_5= 'phone'
                    {
                    enumLiteral_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleInterpretation4924); 

                            current = grammarAccess.getInterpretationAccess().getPhoneEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getInterpretationAccess().getPhoneEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2138:6: (enumLiteral_6= 'time' )
                    {
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2138:6: (enumLiteral_6= 'time' )
                    // ../com.vectorsf.jvoice.voice.dsl/src-gen/com/isb/bks/ivr/voice/dsl/parser/antlr/internal/InternalVoiceDsl.g:2138:8: enumLiteral_6= 'time'
                    {
                    enumLiteral_6=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleInterpretation4941); 

                            current = grammarAccess.getInterpretationAccess().getTimeEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getInterpretationAccess().getTimeEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterpretation"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleVoiceDsl_in_entryRuleVoiceDsl75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVoiceDsl85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInputDsl_in_ruleVoiceDsl132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMenuDsl_in_ruleVoiceDsl159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePromptDsl_in_ruleVoiceDsl186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordDsl_in_ruleVoiceDsl213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransferDsl_in_ruleVoiceDsl240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePromptDsl_in_entryRulePromptDsl275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePromptDsl285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rulePromptDsl322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePromptDsl339 = new BitSet(new long[]{0x0000020002000000L});
        public static final BitSet FOLLOW_ruleConfiguration_in_rulePromptDsl410 = new BitSet(new long[]{0x00000201CE000000L});
        public static final BitSet FOLLOW_ruleCondition_in_rulePromptDsl485 = new BitSet(new long[]{0x00000201CE000000L});
        public static final BitSet FOLLOW_ruleAudios_in_rulePromptDsl553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMenuDsl_in_entryRuleMenuDsl589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMenuDsl599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleMenuDsl636 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMenuDsl653 = new BitSet(new long[]{0x0000020003000000L});
        public static final BitSet FOLLOW_ruleConfiguration_in_ruleMenuDsl724 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleGrammars_in_ruleMenuDsl799 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleCondition_in_ruleMenuDsl874 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleAudios_in_ruleMenuDsl942 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_ruleOutputs_in_ruleMenuDsl963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInputDsl_in_entryRuleInputDsl999 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInputDsl1009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleInputDsl1046 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInputDsl1063 = new BitSet(new long[]{0x0000020003000000L});
        public static final BitSet FOLLOW_ruleConfiguration_in_ruleInputDsl1134 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleGrammars_in_ruleInputDsl1209 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleCondition_in_ruleInputDsl1284 = new BitSet(new long[]{0x00000201CF000000L});
        public static final BitSet FOLLOW_ruleAudios_in_ruleInputDsl1352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordDsl_in_entryRuleRecordDsl1388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecordDsl1398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRecordDsl1435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecordDsl1452 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleRecordDsl1469 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRecordDsl1486 = new BitSet(new long[]{0x0000020002000000L});
        public static final BitSet FOLLOW_ruleConfiguration_in_ruleRecordDsl1557 = new BitSet(new long[]{0x00000201CE000000L});
        public static final BitSet FOLLOW_ruleCondition_in_ruleRecordDsl1632 = new BitSet(new long[]{0x00000201CE000000L});
        public static final BitSet FOLLOW_ruleAudios_in_ruleRecordDsl1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransferDsl_in_entryRuleTransferDsl1736 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransferDsl1746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleTransferDsl1785 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransferDsl1802 = new BitSet(new long[]{0x0000000000F00000L});
        public static final BitSet FOLLOW_18_in_ruleTransferDsl1827 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransferDsl1844 = new BitSet(new long[]{0x0000000000F00000L});
        public static final BitSet FOLLOW_19_in_ruleTransferDsl1869 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransferDsl1886 = new BitSet(new long[]{0x0000000000F00000L});
        public static final BitSet FOLLOW_20_in_ruleTransferDsl1951 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTransferDsl1968 = new BitSet(new long[]{0x00000201CEF00000L});
        public static final BitSet FOLLOW_21_in_ruleTransferDsl2041 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTransferDsl2058 = new BitSet(new long[]{0x00000201CEF00000L});
        public static final BitSet FOLLOW_22_in_ruleTransferDsl2131 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTransferDsl2148 = new BitSet(new long[]{0x00000201CEF00000L});
        public static final BitSet FOLLOW_23_in_ruleTransferDsl2221 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTransferDsl2238 = new BitSet(new long[]{0x00000201CEF00000L});
        public static final BitSet FOLLOW_ruleCondition_in_ruleTransferDsl2311 = new BitSet(new long[]{0x00000001CC000000L});
        public static final BitSet FOLLOW_ruleAudios_in_ruleTransferDsl2333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammars_in_entryRuleGrammars2369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammars2379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleGrammars2425 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleGrammars2437 = new BitSet(new long[]{0x000000E004000000L});
        public static final BitSet FOLLOW_ruleGrammar_in_ruleGrammars2458 = new BitSet(new long[]{0x000000E004000000L});
        public static final BitSet FOLLOW_26_in_ruleGrammars2471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAudios_in_entryRuleAudios2507 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAudios2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAudios2599 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAudios2611 = new BitSet(new long[]{0x00000001DC000002L});
        public static final BitSet FOLLOW_28_in_ruleAudios2624 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleAudios2636 = new BitSet(new long[]{0x0008200000000000L});
        public static final BitSet FOLLOW_ruleConditionalAudio_in_ruleAudios2657 = new BitSet(new long[]{0x00082001CC000002L});
        public static final BitSet FOLLOW_30_in_ruleAudios2728 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleAudios2740 = new BitSet(new long[]{0x0008200000000000L});
        public static final BitSet FOLLOW_ruleConditionalAudio_in_ruleAudios2761 = new BitSet(new long[]{0x00082001CC000002L});
        public static final BitSet FOLLOW_31_in_ruleAudios2830 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleAudios2842 = new BitSet(new long[]{0x0008200000000000L});
        public static final BitSet FOLLOW_ruleConditionalAudio_in_ruleAudios2863 = new BitSet(new long[]{0x00082001CC000002L});
        public static final BitSet FOLLOW_32_in_ruleAudios2932 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleAudios2944 = new BitSet(new long[]{0x0008200000000000L});
        public static final BitSet FOLLOW_ruleConditionalAudio_in_ruleAudios2965 = new BitSet(new long[]{0x00082001CC000002L});
        public static final BitSet FOLLOW_26_in_ruleAudios3034 = new BitSet(new long[]{0x00000001CC000002L});
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration3116 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration3126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleConfiguration3172 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_ruleConfigValue_in_ruleConfiguration3193 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_26_in_ruleConfiguration3206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConfigValue_in_entryRuleConfigValue3242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfigValue3252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConfigValue3294 = new BitSet(new long[]{0x00000018000000C0L});
        public static final BitSet FOLLOW_ruleConfigValueValue_in_ruleConfigValue3320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConfigValueValue_in_entryRuleConfigValueValue3357 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfigValueValue3368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConfigValueValue3409 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_33_in_ruleConfigValueValue3428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleConfigValueValue3447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_FLOAT_in_ruleConfigValueValue3471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleConfigValueValue3495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleConfigValueValue3514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar3554 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammar3564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleGrammar3609 = new BitSet(new long[]{0x0000010000000020L});
        public static final BitSet FOLLOW_38_in_ruleGrammar3638 = new BitSet(new long[]{0x0000010000000020L});
        public static final BitSet FOLLOW_39_in_ruleGrammar3667 = new BitSet(new long[]{0x0000010000000020L});
        public static final BitSet FOLLOW_40_in_ruleGrammar3701 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGrammar3732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCondition_in_entryRuleCondition3773 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCondition3783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleCondition3829 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCondition3846 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCondition3868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOutputs_in_entryRuleOutputs3909 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOutputs3919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleOutputs3956 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleOutputs3968 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleOutput_in_ruleOutputs3989 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_26_in_ruleOutputs4002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOutput_in_entryRuleOutput4038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOutput4048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOutput4090 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleOutput4107 = new BitSet(new long[]{0x0000100000000020L});
        public static final BitSet FOLLOW_ruleOutputValue_in_ruleOutput4128 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_43_in_ruleOutput4141 = new BitSet(new long[]{0x0000100000000020L});
        public static final BitSet FOLLOW_ruleOutputValue_in_ruleOutput4162 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_ruleOutputValue_in_entryRuleOutputValue4200 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOutputValue4210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleOutputValue4252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleOutputValue4281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAudio_in_entryRuleSimpleAudio4330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAudio4340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleSimpleAudio4386 = new BitSet(new long[]{0x0001C00000000002L});
        public static final BitSet FOLLOW_46_in_ruleSimpleAudio4400 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleAudio4417 = new BitSet(new long[]{0x0001800000000002L});
        public static final BitSet FOLLOW_47_in_ruleSimpleAudio4438 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleAudio4455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleSimpleAudio4480 = new BitSet(new long[]{0x07F0000000000000L});
        public static final BitSet FOLLOW_ruleInterpretation_in_ruleSimpleAudio4501 = new BitSet(new long[]{0x0002000000000020L});
        public static final BitSet FOLLOW_49_in_ruleSimpleAudio4514 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleAudio4531 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleSimpleAudio4548 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleAudio4567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConditionalAudio_in_entryRuleConditionalAudio4612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConditionalAudio4622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleConditionalAudio4669 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleConditionalAudio4681 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConditionalAudio4698 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleConditionalAudio4715 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleConditionalAudio4727 = new BitSet(new long[]{0x0008200000000000L});
        public static final BitSet FOLLOW_ruleSimpleAudio_in_ruleConditionalAudio4748 = new BitSet(new long[]{0x0008200004000000L});
        public static final BitSet FOLLOW_26_in_ruleConditionalAudio4761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAudio_in_ruleConditionalAudio4790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleInterpretation4839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleInterpretation4856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleInterpretation4873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleInterpretation4890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleInterpretation4907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleInterpretation4924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleInterpretation4941 = new BitSet(new long[]{0x0000000000000002L});
    }


}